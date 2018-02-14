package com.learn.spring.cloud.eureka.client.gateway.feign;

import feign.RequestLine;

public interface ClientAdjectiveRemoteService {

//    @RequestMapping(value = "/word", method = GET)
    @RequestLine("GET /word")
    String getAdjective();
}

