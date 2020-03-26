package com.raven.cloud.consumer.feign.client.user;

import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Created By Raven on 2020/2/22 13:52
 */
@Component
public class UserConsumerClientFallbackFactory implements FallbackFactory<UserConsumerClient> {

    @Override
    public UserConsumerClient create(Throwable cause) {

        UserConsumerClientBreaker breaker = new UserConsumerClientBreaker();
        if (cause instanceof FeignException) {
            switch (((FeignException) cause).status()) {
                case 403:
                    break;
                case 400:
                    break;
                case 500:
                    break;
                default:
                    break;
            }
        } else {
        }
        return breaker;
    }
}
