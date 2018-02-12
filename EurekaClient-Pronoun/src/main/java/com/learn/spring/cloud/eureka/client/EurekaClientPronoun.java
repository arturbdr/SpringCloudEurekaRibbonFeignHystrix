package com.learn.spring.cloud.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientPronoun {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientPronoun.class, args);
    }
}
