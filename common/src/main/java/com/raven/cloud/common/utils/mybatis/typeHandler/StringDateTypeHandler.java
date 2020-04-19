package com.raven.cloud.common.utils.mybatis.typeHandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * By Raven 2019/8/13
 */
@MappedJdbcTypes(value = JdbcType.VARCHAR, includeNullJdbcType = true)
@MappedTypes(Date.class)
public class StringDateTypeHandler implements TypeHandler<Date> {

    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void setParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
        try {
            ps.setString(i, df.format(parameter));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Date getResult(ResultSet rs, String columnName) throws SQLException {
        try {
            return df.parse(rs.getString(columnName));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Date getResult(ResultSet rs, int columnIndex) throws SQLException {
        try {
            return df.parse(rs.getString(columnIndex));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Date getResult(CallableStatement cs, int columnIndex) throws SQLException {
        try {
            return df.parse(cs.getString(columnIndex));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
