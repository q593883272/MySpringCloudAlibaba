package com.raven.cloud.consumer.feign.client.resource;

import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Created By Raven on 2020/2/22 13:52
 */
@Component
public class ResourceConsumerClientFallbackFactory implements FallbackFactory<ResourceConsumerClientBreaker> {

    @Override
    public ResourceConsumerClientBreaker create(Throwable cause) {

        ResourceConsumerClientBreaker breaker = new ResourceConsumerClientBreaker();
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
