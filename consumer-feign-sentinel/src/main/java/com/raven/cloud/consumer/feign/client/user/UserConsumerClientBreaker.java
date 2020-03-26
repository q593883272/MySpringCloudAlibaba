package com.raven.cloud.consumer.feign.client.user;


import org.springframework.stereotype.Service;

/**
 * Created By Raven on 2020/2/21 16:29
 */
@Service
public class UserConsumerClientBreaker implements UserConsumerClient {

    @Override
    public String find(Long id, String username, String name) {
        return "服务器挂了!";
    }

    @Override
    public String addUser(String username, String name) {
        return "服务器挂了!";
    }
}
