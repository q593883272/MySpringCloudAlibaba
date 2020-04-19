package com.raven.cloud.uaa.model.po.operation;

import com.raven.cloud.common.model.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@FieldNameConstants
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "operation")
public class Operation extends BasePo {
    // 操作标识(主键).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "id", columnDefinition = "integer")
    private Integer id;
    // 操作名称
    @Column(name = "name")
    private String name;
    // 操作码
    @Column(name = "code")
    private String code;
    // 拦截URL前缀
    @Column(name = "blockUrl")
    private String blockUrl;
    // 父操作ID
    @Column(name = "parentId", columnDefinition = "integer")
    private Integer parentId;
}
