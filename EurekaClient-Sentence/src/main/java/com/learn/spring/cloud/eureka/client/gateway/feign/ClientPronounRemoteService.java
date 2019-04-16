package com.learn.spring.cloud.eureka.client.gateway.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("EurekaClientPronoun")
public interface ClientPronounRemoteService {

    @RequestMapping(method = RequestMethod.GET, value = "/word")
    String getPronoun();

}
