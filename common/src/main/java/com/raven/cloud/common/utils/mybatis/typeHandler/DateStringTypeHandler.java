package com.raven.cloud.common.utils.mybatis.typeHandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * By Raven 2018/2/25
 */
@MappedJdbcTypes(value = JdbcType.DATE, includeNullJdbcType = true)
@MappedTypes(String.class)
public class DateStringTypeHandler implements TypeHandler<String> {
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        try {
            ps.setTimestamp(i, new Timestamp(df.parse(parameter).getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        return df.format(rs.getDate(columnName));
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        return df.format(rs.getDate(columnIndex));
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return df.format(cs.getDate(columnIndex));
    }
}
