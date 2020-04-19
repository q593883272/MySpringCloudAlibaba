package com.raven.cloud.uaa.web.controller;

import com.raven.cloud.uaa.model.po.user.UserInfo;
import com.raven.cloud.uaa.service.user.UserInfoService;
import com.raven.cloud.uaa.web.api.ApiRespEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserInfoService userInfoService;

    @Autowired
    public UserController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }


    @GetMapping("/count")
    public ApiRespEntity getUserInfoCount() {
        return ApiRespEntity.success(userInfoService.findCount());
    }

    /**
     * 查询用户信息
     */
    @GetMapping("/{username}/info")
    public ApiRespEntity getUserInfo(@PathVariable("username") String username) {
        return ApiRespEntity.success(userInfoService.findByField(UserInfo.Fields.username, username));
    }

    /**
     * 查询所有用户信息[分页查询]
     */
    @GetMapping({"", "/", "/info", "/all"})
    public List<UserInfo> getUserAll(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage, @RequestParam(value = "pageSize", required = false, defaultValue = "8") Integer pageSize) {
        return userInfoService.findPage(currentPage, pageSize);
    }

    /**
     * 添加用户
     */
    @PostMapping({"/add", "/save"})
    public Boolean addUser(@ModelAttribute UserInfo user) {
        log.info("获取到的: {}", user);
        return userInfoService.add(user);
    }


    @PostMapping("/update")
    public Boolean updateUserByUsername(@RequestParam("updateUsername") String username, @ModelAttribute UserInfo user) {
        log.info("获取到的: {}", user);
        return userInfoService.modifyByField(user, UserInfo.Fields.username, username);
    }
}
