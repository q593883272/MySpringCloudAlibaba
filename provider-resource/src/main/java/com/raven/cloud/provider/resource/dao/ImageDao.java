package com.raven.cloud.provider.resource.dao;

import com.raven.cloud.provider.resource.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created By Raven on 2020/2/27 16:30
 */
@Repository
public interface ImageDao extends JpaRepository<Image, Long> {
}
