package br.com.aprendendo.spring.cloud.eureka.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PegaPalavraController {

	@Value("${palavras}")
	private String palavras;

	@RequestMapping("/palavra")
	public String getPalavra() {
		String [] arrayPalavras = palavras.split(",");
		
		// Com base no valor do chave do arquivo de properties, retorna uma palava randomicamente
		int i = (int)Math.round(Math.random() * (arrayPalavras.length - 1));
	    return arrayPalavras[i];
	}

}
