package com.raven.cloud.consumer.gateway.config;

import com.raven.cloud.consumer.gateway.jwt.JwtReactiveOAuth2UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.ReactiveOAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;

@Slf4j
@Configuration
public class JwtConfiguration {

    @Bean
    ReactiveOAuth2UserService<OAuth2UserRequest, OAuth2User> userService(ReactiveJwtDecoder jwtDecoder) {
        return new JwtReactiveOAuth2UserService(jwtDecoder);
    }

}
