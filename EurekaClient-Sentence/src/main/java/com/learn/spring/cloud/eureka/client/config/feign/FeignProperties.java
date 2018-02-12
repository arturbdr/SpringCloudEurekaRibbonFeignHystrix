package com.learn.spring.cloud.eureka.client.config.feign;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("client.adjective")
@Data
@Component
public class FeignProperties {

    private String name;
    private int connectionTimeoutInMillis;
    private int readTimeoutInMillis;
}
