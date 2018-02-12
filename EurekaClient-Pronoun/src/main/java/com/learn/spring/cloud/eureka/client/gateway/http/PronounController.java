package com.learn.spring.cloud.eureka.client.gateway.http;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class PronounController {

    @Value("${words}")
    private String words;

    @GetMapping("/word")
    public ResponseEntity<String> getPronoun() {
        final String[] wordsArray = words.split(",");

        int i = new Random().nextInt(wordsArray.length);
        return ResponseEntity.ok(wordsArray[i]);
    }
}
