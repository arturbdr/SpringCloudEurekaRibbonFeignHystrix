package com.learn.spring.cloud.eureka.client.gateway.feign;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HystrixClientFallback implements FallbackFactory<ClientAdjectiveRemoteService> {

    @Override
    public ClientAdjectiveRemoteService create(Throwable cause) {
        log.error("Failed to Call service!", cause);
        return () -> "something is not ok";
    }
}
