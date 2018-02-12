package com.learn.spring.cloud.eureka.client.usecase;

import com.learn.spring.cloud.eureka.client.gateway.feign.ClientAdjectiveRemoteService;
import com.learn.spring.cloud.eureka.client.gateway.feign.ClientPronounRemoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WordService {

    private final ClientPronounRemoteService clientPronounRemoteService;
    private final ClientAdjectiveRemoteService adjectiveRemoteService;
    private final LoadBalancerClient loadBalancerClient;
    private final RestTemplate restTemplate;

    public String getPronoun() {
        return clientPronounRemoteService.getPronoun();
    }

    public String getAdjective() {
        return adjectiveRemoteService.getAdjective();
    }

    public Optional<String> getWord(String service) {
        final ServiceInstance serverInstance = loadBalancerClient.choose(service);
        if (serverInstance != null) {
            URI uri = serverInstance.getUri();
            if (uri != null) {
                String word = restTemplate.getForObject(uri + "/word", String.class);

                return Optional.ofNullable(word);
            }
        }
        return Optional.empty();
    }

}
