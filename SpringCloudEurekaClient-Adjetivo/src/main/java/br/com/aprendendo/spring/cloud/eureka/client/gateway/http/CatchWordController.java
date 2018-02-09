package br.com.aprendendo.spring.cloud.eureka.client.gateway.http;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class CatchWordController {

    @Value("${app.words}")
    private String words;

    @GetMapping("/word")
    public String getAdjective() {
        String[] wordsArray = this.words.split(",");

        int wordPosition = new Random().nextInt(wordsArray.length);
        return wordsArray[wordPosition];
    }

}
