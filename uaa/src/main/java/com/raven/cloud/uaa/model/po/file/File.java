package com.raven.cloud.uaa.model.po.file;


import com.raven.cloud.common.model.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@FieldNameConstants()
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "file")
public class File extends BasePo {

    // 文件标识(主键).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "id", columnDefinition = "integer")
    private Integer id;
    // 文件名
    @Column(name = "name", nullable = false)
    private String name;
    // 路径
    @Column(name = "path", nullable = false)
    private String path;
}
