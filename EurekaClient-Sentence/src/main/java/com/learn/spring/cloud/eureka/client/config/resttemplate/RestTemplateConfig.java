package com.learn.spring.cloud.eureka.client.config.resttemplate;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate configRestTemplate() {
        return new RestTemplateBuilder()
                .build();
    }
}
