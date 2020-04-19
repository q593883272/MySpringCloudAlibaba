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
@Table(name = "user_status")
public class UserStatus extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "id", columnDefinition = "integer")
    private Integer id;
    // 账号
    @Column(name = "username", length = 64, nullable = false, unique = true )
    private String username;
    // 密码
    @Column(name = "password", length = 255, nullable = false )
    private String password;
    // 帐户是否未过期
    @Column(name = "account_non_expired", length = 1, nullable = false, columnDefinition = "integer default 1")
    private Boolean accountNonExpired;
    // 帐户是否未锁定
    @Column(name = "account_non_locked", length = 1, nullable = false, columnDefinition = "integer default 1")
    private Boolean accountNonLocked;
    // 凭证是否未过期
    @Column(name = "credentials_non_expired", length = 1, nullable = false, columnDefinition = "integer default 1")
    private Boolean credentialsNonExpired;
    // 帐户是否启用
    @Column(name = "enabled", length = 1, nullable = false, columnDefinition = "integer default 0")
    private Boolean enabled;
}
