package com.raven.cloud.consumer.feign.client.resource;

import com.raven.cloud.consumer.feign.client.user.UserConsumerClientBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created By Raven on 2020/2/21 14:34
 */
@Primary
@FeignClient(value = "resource-provider-server-service", fallbackFactory = ResourceConsumerClientFallbackFactory.class)
public interface ResourceConsumerClient {

    @GetMapping("/resource/image/find")
    String findImage(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "name", required = false) String name);


    @GetMapping("/resource/image/add")
    String addImage(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "path", required = false) String path);

}
