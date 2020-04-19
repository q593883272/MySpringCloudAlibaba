package com.raven.cloud.uaa.model.po.power;

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
@Table(name = "power_menu")
public class PowerMenu extends BasePo {

    // 主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "id")
    private Integer id;
    // 权限ID
    @Column(name = "power_id", nullable = false, columnDefinition = "integer")
    private Integer powerId;
    // 菜单ID
    @Column(name = "menu_id", nullable = false, columnDefinition = "integer")
    private Integer menuId;
}
