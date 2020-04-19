package com.raven.cloud.uaa.model.po.user;

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
@Table(name = "user_status_role")
public class UserStatusRole extends BasePo {

    // 主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "id", columnDefinition = "integer")
    private Integer id;
    // 用户账号
    @Column(name = "username", nullable = false )
    private String username;
    // 角色ID
    @Column(name = "role_id", nullable = false, columnDefinition = "integer")
    private Integer roleId;
}
