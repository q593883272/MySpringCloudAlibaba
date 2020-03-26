package com.raven.cloud.consumer.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 网关服务
 * Created By Raven on 2/23/2020 11:42 AM
 */
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

    @GetMapping({"", "/"})
    public String hello(@Value("${spring.application.name}") String serviceName, @Value("${server.port}") String path) {
        return serviceName + " port: " + path;
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
