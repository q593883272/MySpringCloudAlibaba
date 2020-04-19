package com.raven.cloud.common.utils.mybatis.typeHandler;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * String映射为Class
 */
@Slf4j
@MappedJdbcTypes(value = JdbcType.VARCHAR, includeNullJdbcType = true)
@MappedTypes(Class.class)
public class StringClassTypeHandler implements TypeHandler<Class> {

    @Override
    public void setParameter(PreparedStatement ps, int i, Class parameter, JdbcType jdbcType) throws SQLException {
        log.info(parameter.getName());
        try {
            ps.setString(i, parameter.getName());
        } catch (Exception ex) {
            ex.printStackTrace();
            ps.setString(i, null);
        }
    }

    @Override
    public Class getResult(ResultSet rs, String columnName) throws SQLException {
        try {
            return Class.forName(rs.getString(columnName));
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Class getResult(ResultSet rs, int columnIndex) throws SQLException {
        try {
            return Class.forName(rs.getString(columnIndex));
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Class getResult(CallableStatement cs, int columnIndex) throws SQLException {
        try {
            return Class.forName(cs.getString(columnIndex));
        } catch (Exception ex) {
            return null;
        }
    }
}
