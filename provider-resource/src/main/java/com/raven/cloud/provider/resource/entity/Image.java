package com.raven.cloud.provider.resource.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * Created By Raven on 2/23/2020 1:25 PM
 */
@Entity
@Table(name = "image")
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String filePath;

}
