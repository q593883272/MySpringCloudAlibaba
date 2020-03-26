package com.raven.cloud.consumer.gateway.config;

import com.raven.cloud.consumer.gateway.jwt.JwtOAuth2AuthenticationTokenConverter;
import org.springframework.boot.autoconfigure.security.oauth2.resource.reactive.ReactiveOAuth2ResourceServerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * Created by Steven on 2019/10/27.
 */
@EnableWebFluxSecurity
public class ResourceServerConfiguration {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http.authorizeExchange().pathMatchers("/actuator/**").permitAll().anyExchange().authenticated()
                .and()
                .oauth2ResourceServer().jwt().jwtAuthenticationConverter(new JwtOAuth2AuthenticationTokenConverter())
                .and().and()
                .build();
    }
}
