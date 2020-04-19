package com.raven.cloud.uaa.model.po.usergroup;

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
@Table(name = "user_group_user_status")
public class UserGroupUserStatus extends BasePo {

    // 主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "id", columnDefinition = "integer")
    private Integer id;
    // 用户组表ID
    @Column(name = "user_group_id", nullable = false, columnDefinition = "integer")
    private Integer userGroupId;
    // 用户名
    @Column(name = "username", nullable = false )
    private String username;
}
