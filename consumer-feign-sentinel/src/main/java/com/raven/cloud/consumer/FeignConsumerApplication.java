package com.raven.cloud.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务消费者
 * Created By Raven on 2020/2/21 14:30
 */

//@EnableBinding({MyOutput.class, MyInput.class})
@EnableFeignClients
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class FeignConsumerApplication {

    @GetMapping({"", "/"})
    public String hello(@Value("${spring.application.name}") String serviceName, @Value("${server.port}") String path) {
        return serviceName + " port: " + path;
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class, args);
    }

//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource dataSource(DataSourceProperties dsp) {
//        HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setJdbcUrl(dsp.getUrl());
//        dataSource.setUsername(dsp.getUsername());
//        dataSource.setPassword(dsp.getPassword());
//        dataSource.setDriverClassName(dsp.getDriverClassName());
//        return dataSource;
//    }
//
//    @Primary
//    @Bean("dataSource")
//    public DataSourceProxy dataSource(DataSource dataSource) {
//        return new DataSourceProxy(dataSource);
//    }

}
