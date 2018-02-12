package com.learn.spring.cloud.eureka.client.gateway.feign;

import com.learn.spring.cloud.eureka.config.FeignAdjectiveConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(value = "${client.adjective.name}", configuration = FeignAdjectiveConfig.class, fallbackFactory = HystrixClientFallback.class)
public interface ClientAdjectiveRemoteService {

    @RequestMapping(value = "/word", method = GET)
    String getAdjective();
}

