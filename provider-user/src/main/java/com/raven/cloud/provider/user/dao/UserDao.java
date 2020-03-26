package com.raven.cloud.provider.user.dao;

import com.raven.cloud.provider.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created By Raven on 2020/2/27 16:30
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
