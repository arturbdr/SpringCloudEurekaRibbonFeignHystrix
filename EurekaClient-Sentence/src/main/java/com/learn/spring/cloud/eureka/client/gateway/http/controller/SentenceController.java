package com.learn.spring.cloud.eureka.client.gateway.http.controller;

import com.learn.spring.cloud.eureka.client.usecase.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SentenceController {

    private final WordService wordService;

    @GetMapping("/sentence/loadbalance")
    public String getSentenca() {
        StringBuffer sentence = new StringBuffer();

        sentence.append(wordService.getWord("EurekaClientPronoun").get());
        sentence.append(" ");
        sentence.append(wordService.getWord("EurekaClientAdjective").get());

        return sentence.toString();
    }

    @GetMapping("/sentence/feign")
    public String getSentencaFeign() {
        return wordService.getPronoun() + wordService.getAdjective();
    }


}
