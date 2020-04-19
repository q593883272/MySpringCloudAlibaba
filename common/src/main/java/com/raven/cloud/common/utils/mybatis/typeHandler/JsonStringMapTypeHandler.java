package com.raven.cloud.common.utils.mybatis.typeHandler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * JSON映射为Map
 */
@Slf4j
@MappedJdbcTypes(value = JdbcType.VARCHAR, includeNullJdbcType = true)
@MappedTypes(Map.class)
public class JsonStringMapTypeHandler implements TypeHandler<Map<String, Object>> {

    private Gson jsonFormat = new Gson();

    @Override
    public void setParameter(PreparedStatement ps, int i, Map<String, Object> map, JdbcType jdbcType) throws SQLException {

        log.info("{}", map);
        log.info(jsonFormat.toJson(map));
        try {
            ps.setString(i, jsonFormat.toJson(map));
        } catch (Exception ex) {
            ex.printStackTrace();
            ps.setString(i, null);
        }
    }

    @Override
    public Map<String, Object> getResult(ResultSet rs, String columnName) throws SQLException {
        try {
            return jsonFormat.fromJson(rs.getString(columnName), new TypeToken<Map<String, Object>>() {
            }.getType());
        } catch (Exception ex) {
            return new HashMap<>();
        }
    }

    @Override
    public Map<String, Object> getResult(ResultSet rs, int columnIndex) throws SQLException {
        try {
            return jsonFormat.fromJson(rs.getString(columnIndex), new TypeToken<Map<String, Object>>() {
            }.getType());
        } catch (Exception ex) {
            return new HashMap<>();
        }
    }

    @Override
    public Map<String, Object> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        try {
            return jsonFormat.fromJson(cs.getString(columnIndex), new TypeToken<Map<String, Object>>() {
            }.getType());
        } catch (Exception ex) {
            return new HashMap<>();
        }

    }
}
