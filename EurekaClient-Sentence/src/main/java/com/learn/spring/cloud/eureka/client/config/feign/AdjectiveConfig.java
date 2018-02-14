package com.learn.spring.cloud.eureka.client.config.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.spring.cloud.eureka.client.gateway.feign.ClientAdjectiveRemoteService;
import feign.Client;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.ribbon.RibbonClient;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.feign.ribbon.LoadBalancerFeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AdjectiveConfig {

    private final ObjectMapper objectMapper;
    private final LoadBalancerFeignClient loadBalancerClient;
//    private final Client client;


    @Bean
    public ClientAdjectiveRemoteService configAdjective() {
        return Feign.builder()
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .client(loadBalancerClient)
                .target(ClientAdjectiveRemoteService.class, "http://EurekaClientAdjective");
    }
}
