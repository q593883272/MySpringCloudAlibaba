package com.raven.cloud.uaa.dao;

import com.raven.cloud.uaa.model.po.role.Role;
import com.raven.cloud.uaa.model.po.user.UserStatus;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface UserStatusDao extends Mapper<UserStatus> {

    List<Role> selectUserRoles(@Param("username") String username);

}
