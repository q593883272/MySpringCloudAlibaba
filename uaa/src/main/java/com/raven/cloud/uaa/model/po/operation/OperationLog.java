package com.raven.cloud.uaa.model.po.operation;

import com.raven.cloud.common.model.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@FieldNameConstants
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "operation_log")
public class OperationLog extends BasePo {

    // 操作日志标识(主键).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "id", columnDefinition = "integer")
    private Integer id;
    // 操作表ID
    @Column(name = "operation_id", nullable = false)
    private String operationId;
    // 操作内容
    @Column(name = "content", nullable = false)
    private String content;
    // 操作用户名
    @Column(name = "username", nullable = false)
    private String username;
    // 操作时间
    @Column(name = "date_time", nullable = false, columnDefinition = "datetime default now()")
    private Date dateTime;

}
