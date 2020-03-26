package com.raven.cloud.uaa.config.oauth2;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;

@Component
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || username.isEmpty()) {
            throw new UsernameNotFoundException("username is empty!");
        }
        switch (username) {
            case "admin":
                return new User("admin", passwordEncoder.encode("admin"), Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
            case "root":
                return new User("root", passwordEncoder.encode("root"), Arrays.asList(new SimpleGrantedAuthority("ROLE_ROOT")));
            case "q593883272":
                return new User("q593883272", passwordEncoder.encode("88888888"), Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
        }
        throw new UsernameNotFoundException("账户不存在!");
    }
}
