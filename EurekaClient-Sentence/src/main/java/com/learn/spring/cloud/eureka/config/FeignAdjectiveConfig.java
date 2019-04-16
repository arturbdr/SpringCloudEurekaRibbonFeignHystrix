package com.learn.spring.cloud.eureka.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.spring.cloud.eureka.client.config.feign.FeignProperties;
import feign.Logger;
import feign.Request;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import static feign.FeignException.errorStatus;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class FeignAdjectiveConfig {

    private final ObjectMapper objectMapper;
    private final FeignProperties feignProperties;

    @Bean
    public Decoder feignDecoder() {
        HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(objectMapper);
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
        return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
    }

    @Bean
    public Encoder feignEncoder() {
        HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(objectMapper);
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
        return new SpringEncoder(objectFactory);
    }

    @Bean
    public Logger.Level feignLogger() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder feignErrorDecoder() {
        return (methodKey, response) -> {
            if (response.status() >= 400 && response.status() <= 499) {
                return new RuntimeException("Error 400");
            }
            if (response.status() >= 500 && response.status() <= 599) {
                return new RuntimeException("Error 500");
            }
            return errorStatus(methodKey, response);
        };
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(feignProperties.getConnectionTimeoutInMillis(), feignProperties.getConnectionTimeoutInMillis());
    }
}
