package com.raven.cloud.consumer.gateway.filter;

import com.raven.cloud.consumer.gateway.jwt.JwtOAuth2User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
public class PreOAuth2GatewayFilter extends AbstractGatewayFilterFactory<PreOAuth2GatewayFilter.Config> {

    public PreOAuth2GatewayFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {

        // 转发用户信息
        return (exchange, chain) -> ReactiveSecurityContextHolder.getContext()
                .filter(Objects::nonNull)
                .map(SecurityContext::getAuthentication)
                .filter(authentication -> authentication instanceof OAuth2AuthenticationToken)
                .map(authentication -> (OAuth2AuthenticationToken) authentication)
                .map(OAuth2AuthenticationToken::getPrincipal)
                .map(bearerToken -> {
                    ServerHttpRequest.Builder builder = exchange.getRequest().mutate();
                    builder.header(HttpHeaders.AUTHORIZATION, bearerToken.getName());
                    ServerHttpRequest request = builder.build();
                    return exchange.mutate().request(request).build();
                })
                .defaultIfEmpty(exchange)
                .flatMap(chain::filter);


        // 转发AuthorizationToken
//        return (exchange, chain) -> ReactiveSecurityContextHolder.getContext()
//                .filter(Objects::nonNull)
//                .map(SecurityContext::getAuthentication)
//                .filter(authentication -> authentication instanceof OAuth2AuthenticationToken)
//                .map(authentication -> (OAuth2AuthenticationToken) authentication)
//                .map(OAuth2AuthenticationToken::getPrincipal)
//                .filter(oauth2User -> Objects.nonNull(oauth2User) && oauth2User instanceof JwtOAuth2User)
//                .map(o -> (JwtOAuth2User) o)
//                .map(JwtOAuth2User::getJwtTokenValue)
//                .map(bearerToken -> {
//                    ServerHttpRequest.Builder builder = exchange.getRequest().mutate();
//                    builder.header(HttpHeaders.AUTHORIZATION, "Bearer " + bearerToken);
//                    ServerHttpRequest request = builder.build();
//                    return exchange.mutate().request(request).build();
//                })
//                .defaultIfEmpty(exchange)
//                .flatMap(chain::filter);

    }

    public static class Config {

    }

}
