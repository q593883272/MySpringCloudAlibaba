package com.raven.cloud.uaa.dao;

import com.raven.cloud.uaa.model.po.user.UserInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


//@Repository
//interface UserInfoDao : JpaRepository<UserInfo, String> {
//
//    @Query(value = "select * from user_info where username like %:username%", nativeQuery = true)
//    fun findByUsernameLike(@Param("username") username: String): List<UserInfo>
//
//    //@Param("username") username: String,
//    fun updateUser(@Param("userInfo") user: UserInfo): Boolean
//
////    fun findAll(@PageableDefault(value = 8, sort = ["username"]) pageable: Pageable): Page<User>
//}

@org.apache.ibatis.annotations.Mapper
@Repository
public interface UserInfoDao extends Mapper<UserInfo>{

}
