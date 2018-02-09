package br.com.aprendendo.spring.cloud.eureka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.aprendendo.spring.cloud.feign.ClientAdjetiveRemoteService;
import br.com.aprendendo.spring.cloud.feign.ClientPronounRemoteServices;

@Service
public class PalavrasService {

	private ClientPronounRemoteServices clientPronounRemoteServices;

	private ClientAdjetiveRemoteService adjetivoRemoteService;

	@HystrixCommand(fallbackMethod="erroPronome")
	public String getPronome() {
		return clientPronounRemoteServices.getPronoun();
	}

	@HystrixCommand(fallbackMethod="erroAdjetivo")
	public String getAdjetivo() {
		return adjetivoRemoteService.getAdjective();
	}
	
	
	public Object erroAdjetivo() {
		return "Esta dando erro ao recuperar os adjetivos";
	}
	
	public Object erroPronome() {
		return "Esta dando ao recuperar os pronomes";
	}

}
