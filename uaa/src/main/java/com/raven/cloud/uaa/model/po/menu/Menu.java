package com.raven.cloud.uaa.model.po.menu;

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
@Table(name = "menu")
public class Menu extends BasePo {
    // 菜单标识(主键).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "id", columnDefinition = "integer")
    private Integer id;
    // 菜单URL
    @Column(name = "url", nullable = false)
    private String url;
    // 菜单名称
    @Column(name = "name", nullable = false)
    private String name;
    // 菜单图标
    @Column(name = "icon")
    private String icon;
    // 菜单显示顺序
    @Column(name = "sequence", columnDefinition = "integer")
    private Integer sequence;
    // 父菜单ID
    @Column(name = "parent_id", columnDefinition = "integer")
    private Integer parentId;

}
