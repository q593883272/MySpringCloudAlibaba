package com.raven.cloud.provider.resource;

import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.converter.CompositeMessageConverterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * 服务提供者
 * Created By Raven on 2020/2/21 14:30
 */
@EnableTransactionManagement
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class ResourceProviderApplication {

    @GetMapping({"", "/"})
    public String hello(@Value("${spring.application.name}") String serviceName, @Value("${server.port}") String path) {
        return serviceName + " port: " + path;
    }

    public static void main(String[] args) {
        SpringApplication.run(ResourceProviderApplication.class, args);
    }

    @Bean
    public CompositeMessageConverterFactory compositeMessageConverterFactory() {
        return new CompositeMessageConverterFactory();
    }


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(DataSourceProperties dsp) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(dsp.getUrl());
        dataSource.setUsername(dsp.getUsername());
        dataSource.setPassword(dsp.getPassword());
        dataSource.setDriverClassName(dsp.getDriverClassName());
        return dataSource;
    }

    @Primary
    @Bean("dataSource")
    public DataSourceProxy dataSource(DataSource dataSource) {
        return new DataSourceProxy(dataSource);
    }


//    @Bean
//    public GlobalTransactionScanner globalTransactionScanner(){
//        return new GlobalTransactionScanner("resource-provider-server-service-seata-tx-service-group");
//    }

}
