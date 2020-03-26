package com.raven.cloud.consumer.feign.config;


import com.raven.cloud.consumer.feign.interceptor.FeignRequestHeaderInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign配置注册
 **/
@Configuration
public class FeignConfiguration {


    //全局
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignRequestHeaderInterceptor();
    }

//    @Bean
//    public RequestContextListener requestContextListener() {
//        return new RequestContextListener();
//    }
}
