package br.com.learn.spring.cloud.eureka.client.gateway.http;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class CatchWordController {

    @Value("${palavras}")
    private String words;

    @GetMapping("/word")
    public String getPronoun() {
        String[] wordsArray = words.split(",");

        int i = new Random().nextInt(wordsArray.length);
        return wordsArray[i];
    }

}
