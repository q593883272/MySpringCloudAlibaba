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
@Table(name = "role_power")
public class RolePower extends BasePo {

    // 主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "id", columnDefinition = "integer")
    private Integer id;
    // 角色ID
    @Column(name = "role_id", nullable = false, columnDefinition = "integer")
    private Integer roleId;
    // 权限ID
    @Column(name = "power_id", nullable = false, columnDefinition = "integer")
    private Integer powerId;

}
