package com.raven.cloud.common.model.po;

import com.raven.cloud.common.utils.mybatis.typeHandler.StringDateTypeHandler;
import com.raven.cloud.common.utils.sqlite.DateConverter;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Date;

@Data
@Accessors(chain = true)
@MappedSuperclass
public class BasePo {

    ///////////////////////////////////////////////////////////////////////////
    // 表操作信息
    ///////////////////////////////////////////////////////////////////////////
    // 版本
    @Version
    @Column(name = "version", length = 8, nullable = false, columnDefinition = "integer default 1")
    protected Integer version;
    // 修改人
    @Column(name = "update_user", length = 32, nullable = false, columnDefinition = "text default 'admin'")
    protected String updateUser;
    // 修改时间
    @Column(name = "update_date", nullable = false, columnDefinition = "datetime default now()")
    @Convert(converter = DateConverter.class)
    @ColumnType(typeHandler = StringDateTypeHandler.class, jdbcType = JdbcType.VARCHAR)
    protected Date updateDate;
    // 创建人
    @Column(name = "create_user", length = 32, nullable = false, columnDefinition = "text default 'admin'")
    protected String createUser;
    // 创建时间
    @Column(name = "create_date", nullable = false, columnDefinition = "datetime default now()")
    @Convert(converter = DateConverter.class)
    @ColumnType(typeHandler = StringDateTypeHandler.class, jdbcType = JdbcType.VARCHAR)
    protected Date createDate;

}
