package com.raven.cloud.consumer.feign.client.resource;


import com.raven.cloud.consumer.feign.client.user.UserConsumerClient;
import org.springframework.stereotype.Service;

/**
 * Created By Raven on 2020/2/21 16:29
 */
@Service
public class ResourceConsumerClientBreaker implements ResourceConsumerClient {

    @Override
    public String findImage(Long id, String name) {
        return "服务器挂了!";
    }

    @Override
    public String addImage(String name, String path) {
        return "服务器挂了!";
    }
}
