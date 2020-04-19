package com.raven.cloud.common.utils.mybatis;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeException;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.UnknownTypeHandler;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisColumnUtils {

    public static void handle(Configuration configuration) throws NoSuchFieldException, IllegalAccessException {
        //为防止重复处理,这里进行一次缓存.
        Map<Class, List<ResultMapping>> typeResultMap = new HashMap<>(128);

        //设置 configuration 中的 resultMaps
        Field resultMapsField = configuration.getClass().getDeclaredField("resultMaps");
        resultMapsField.setAccessible(true);
        Map<String, ?> resultMapMap = (Map<String, ?>) resultMapsField.get(configuration);
        Map<String, ResultMap> resultMapProxy = new HashMap<>();
        for (Map.Entry<String, ?> entry : resultMapMap.entrySet()) {
            if (entry.getValue() instanceof ResultMap) {
                ResultMap map = processColumn(configuration, (ResultMap) entry.getValue(), typeResultMap);
                resultMapProxy.put(entry.getKey(), map);
            }
        }
        resultMapsField.set(configuration, resultMapProxy);

        // 设置 configuration 中的 mappedStatements.
        Field mappedStatementsField = configuration.getClass().getDeclaredField("mappedStatements");
        mappedStatementsField.setAccessible(true);
        Map<String, ?> mappedStatement = (Map<String, ?>) mappedStatementsField.get(configuration);
        // resultMaps 在 MappedStatement 中,所在需要再一次进行反射.
        Field resultMapsMsField = MappedStatement.class.getDeclaredField("resultMaps");
        resultMapsMsField.setAccessible(true);
        for (Map.Entry<String, ?> stringMappedStatementEntry : mappedStatement.entrySet()) {
            if (stringMappedStatementEntry.getValue() instanceof MappedStatement) {
                List<ResultMap> resultMaps = new ArrayList<>();
                for (ResultMap resultMap : ((MappedStatement) stringMappedStatementEntry.getValue()).getResultMaps()) {
                    resultMaps.add(processColumn(configuration, resultMap, typeResultMap));
                }
                resultMapsMsField.set(stringMappedStatementEntry.getValue(), resultMaps);
            }
        }
    }

    private static ResultMap processColumn(Configuration configuration, ResultMap resultMap, Map<Class, List<ResultMapping>> typeResultMap) {
        Class<?> type = resultMap.getType();
        if (null == type.getAnnotation(Entity.class)) {
            return resultMap;
        }
        if (!typeResultMap.containsKey(type)) {
            List<ResultMapping> resultMappingList = new ArrayList<>();
            for (Field field : type.getDeclaredFields()) {
                Column column = field.getAnnotation(Column.class);
                if (null != column) {
                    ColumnType columnType = field.getAnnotation(ColumnType.class);
                    if (null != columnType) {
                        if (columnType.typeHandler() != UnknownTypeHandler.class) {
                            resultMappingList.add(new ResultMapping.Builder(configuration, field.getName(), column.name(), getInstance(field.getType(), columnType.typeHandler())).build());
                        }
                    } else {
                        resultMappingList.add(new ResultMapping.Builder(configuration, field.getName(), column.name(), field.getType()).build());
                    }
                }
            }
            typeResultMap.put(type, resultMappingList);
        }
        return new ResultMap.Builder(configuration, resultMap.getId(), resultMap.getType(), typeResultMap.get(type)).build();
    }

    private static <T> TypeHandler<T> getInstance(Class<?> javaTypeClass, Class<?> typeHandlerClass) {
        if (javaTypeClass != null) {
            try {
                Constructor<?> c = typeHandlerClass.getConstructor(Class.class);
                return (TypeHandler<T>) c.newInstance(javaTypeClass);
            } catch (NoSuchMethodException ignored) {
                // ignored
            } catch (Exception e) {
                throw new TypeException("Failed invoking constructor for handler " + typeHandlerClass, e);
            }
        }
        try {
            Constructor<?> c = typeHandlerClass.getConstructor();
            return (TypeHandler<T>) c.newInstance();
        } catch (Exception e) {
            throw new TypeException("Unable to find a usable constructor for " + typeHandlerClass, e);
        }
    }
}
