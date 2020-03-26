package com.raven.cloud.consumer;

import com.raven.cloud.consumer.feign.client.resource.ResourceConsumerClient;
import com.raven.cloud.consumer.feign.client.user.UserConsumerClient;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created By Raven on 2020/2/21 15:58
 */
@Slf4j
@RestController
@RequestMapping({"", "/"})
public class Api {

    @Autowired
    private UserConsumerClient userConsumerClient;

    @Autowired
    private ResourceConsumerClient resourceConsumerClient;

//    @Autowired
//    private RxStreamConsumer streamConsumer;

    @RequestMapping("/user")
    public Authentication getUser(Authentication user){
        return user;
    }

    @GetMapping({"/user/test"})
    public String findUser(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "username", required = false) String username, @RequestParam(value = "name", required = false) String name, @RequestHeader Map<String, Object> headers) {
        log.info("当前用户Headers: {}", headers);
        return userConsumerClient.find(id, username, name);
    }

    @GetMapping({"/image/test"})
    public String findImage(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "name", required = false) String name) {
        return resourceConsumerClient.findImage(id, name);
    }

    @GetMapping({"/tx/test"})
    @GlobalTransactional
    public String transaction(@RequestParam(value = "imageName", required = false, defaultValue = "xxx") String imageName, @RequestParam(value = "username", required = false, defaultValue = "xxx") String username) {
        userConsumerClient.addUser(username, null);
        resourceConsumerClient.addImage(imageName, null);
//        int i = 1 / 0;
        return "没问题!";
    }

    @GetMapping({"/stream/test"})
    public String testStream(@RequestParam(value = "imageName", required = false, defaultValue = "test message") String msg) {
//        streamConsumer.receive020(new );
        return "OK";
    }

}
