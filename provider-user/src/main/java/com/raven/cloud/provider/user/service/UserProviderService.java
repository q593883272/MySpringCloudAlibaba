package com.raven.cloud.provider.user.service;

import com.alibaba.fastjson.JSON;
import com.raven.cloud.provider.user.dao.UserDao;
import com.raven.cloud.provider.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created By Raven on 2020/2/21 14:33
 */
@Slf4j
@RestController
@RequestMapping({"/user"})
public class UserProviderService {

    @Autowired
    private UserDao userDao;

    @GetMapping("/find")
    public String findUser(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "username", required = false) String username, @RequestParam(value = "name", required = false) String name, @RequestHeader Map<String, Object> headers) {
        Example<User> ex = Example.of(new User().setId(id).setUsername(username).setName(name));
        log.info("当前用户 Headers: {}", headers);
        log.info("当前用户 Authentication: {}", SecurityContextHolder.getContext().getAuthentication());
        return JSON.toJSONString(userDao.findAll(ex));
    }

    @Transactional
    @GetMapping("/add")
    public String addUser(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "name", required = false) String name) {
        return JSON.toJSONString(userDao.save(new User().setUsername(username).setName(name)));
    }

}
