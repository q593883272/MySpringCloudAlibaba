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
@Table(name = "power")
public class Power extends BasePo {
    // 权限标识(主键).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "id", columnDefinition = "integer")
    private Integer id;
    // 权限类型
    @Column(name = "type", nullable = false)
    private String type;
}
