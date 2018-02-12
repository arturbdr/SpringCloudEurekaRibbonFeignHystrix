package com.learn.spring.cloud.eureka.client.gateway.feign;

public class CommonsTestingConfig {

    static {
        System.setProperty("eureka.client.enabled", "false");
        System.setProperty("spring.cloud.config.failFast", "false");
    }
}
