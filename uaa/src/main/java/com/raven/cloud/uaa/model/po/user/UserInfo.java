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
@Table(name = "user_info")
public class UserInfo extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "id", columnDefinition = "integer")
    private Integer id;
    // 账号
    @Column(name = "username", length = 64, nullable = false, unique = true)
    private String username;
    // 用户名称
    @Column(name = "name", length = 32, nullable = false)
    private String name;
    // 性别
    @Column(name = "gender", length = 1, nullable = false, columnDefinition = "integer default '-1'")
    private Integer gender;
    // 身份证
    @Column(name = "id_card", length = 20, nullable = true, unique = true, columnDefinition = "varchar default null")
    private String idCard;
    // 电话
    @Column(name = "phone", length = 11, nullable = true, unique = true, columnDefinition = "varchar default null")
    private String phone;
    // 邮箱
    @Column(name = "email", length = 64, nullable = true, unique = true, columnDefinition = "varchar default null")
    private String email;

}
