package com.raven.cloud.uaa.config.oauth2;

import com.raven.cloud.uaa.model.po.user.UserInfo;
import com.raven.cloud.uaa.model.po.user.UserStatus;
import com.raven.cloud.uaa.service.user.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;

@Component

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsPasswordEncoder passwordEncoder;
    private final UserInfoService userInfoService;

    @Autowired
    public UserDetailsServiceImpl(UserDetailsPasswordEncoder passwordEncoder, UserInfoService userInfoService) {
        this.passwordEncoder = passwordEncoder;
        this.userInfoService = userInfoService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || username.isEmpty()) {
            throw new UsernameNotFoundException("username is empty!");
        }

        UserInfo userInfo = userInfoService.findByField(UserStatus.Fields.username, username);

        if (userInfo == null) {
            throw new UsernameNotFoundException("username is not found!");
        }

        if (username.equals(userInfo.getUsername())){
//            return new User(userInfo.getUsername(), passwordEncoder.encode(userInfo.get()), Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
        }

        throw new UsernameNotFoundException("账户不存在!");
    }
}
