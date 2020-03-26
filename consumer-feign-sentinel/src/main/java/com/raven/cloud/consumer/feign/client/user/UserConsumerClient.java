package com.raven.cloud.consumer.feign.client.user;

import com.raven.cloud.consumer.feign.interceptor.FeignRequestHeaderInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created By Raven on 2020/2/21 14:34
 */
@Primary
@FeignClient(value = "user-provider-server-service"/*, fallbackFactory = UserConsumerClientFallbackFactory.class*/)
public interface UserConsumerClient {

    @GetMapping("/user/find")
    String find(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "username", required = false) String username, @RequestParam(value = "name", required = false) String name);

    @GetMapping("/user/add")
    String addUser(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "name", required = false) String name);

}
