package br.com.aprendendo.spring.cloud.eureka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.aprendendo.spring.cloud.feign.ClientAdjetivoRemoteService;
import br.com.aprendendo.spring.cloud.feign.ClientPronomeRemoteServices;

@Service
public class PalavrasService {

	@Autowired
	private ClientPronomeRemoteServices clientPronomeRemoteServices;

	@Autowired
	private ClientAdjetivoRemoteService adjetivoRemoteService;

	@HystrixCommand(fallbackMethod="erroPronome")
	public String getPronome() {
		return clientPronomeRemoteServices.getPronome();
	}

	@HystrixCommand(fallbackMethod="erroAdjetivo")
	public String getAdjetivo() {
		return adjetivoRemoteService.getAdjetivo();
	}
	
	
	public Object erroAdjetivo() {
		return "Esta dando ao recuperar os adjetivos";
	}
	
	public Object erroPronome() {
		return "Esta dando ao recuperar os pronomes";
	}

}
