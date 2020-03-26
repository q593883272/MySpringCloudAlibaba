package com.raven.cloud.uaa;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 服务提供者
 * Created By Raven on 2020/2/21 14:30
 */
@EnableDiscoveryClient
@SpringBootApplication
public class UaaApplication {

    @GetMapping({"", "/"})
    public String hello(@Value("${spring.application.name}") String serviceName, @Value("${server.port}") String path) {
        return serviceName + " port: " + path;
    }

    public static void main(String[] args) {
        SpringApplication.run(UaaApplication.class, args);
    }
}
