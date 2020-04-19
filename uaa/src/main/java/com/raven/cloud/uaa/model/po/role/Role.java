package com.raven.cloud.uaa.model.po.role;

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
@Table(name = "role")
public class Role extends BasePo {
    // 角色标识(主键).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "id", columnDefinition = "integer")
    private Integer id;
    // 角色名称
    @Column(name = "name", length = 32, nullable = false )
    private String name;
}
