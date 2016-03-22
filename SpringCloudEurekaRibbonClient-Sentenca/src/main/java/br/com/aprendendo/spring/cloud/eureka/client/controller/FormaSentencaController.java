package br.com.aprendendo.spring.cloud.eureka.client.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.aprendendo.spring.cloud.eureka.service.PalavrasService;

@RestController
public class FormaSentencaController {

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@Autowired
	private PalavrasService palavrasService;

	/**
	 * @return String chamando os serviços utilizando Ribbon e Eureka
	 */
	@RequestMapping("/sentenca/loadbalance")
	public String getSentenca() {
		StringBuffer sentenca = new StringBuffer();

		sentenca.append(getWord("EurekaClientPronome"));
		sentenca.append(getWord("EurekaClientAdjetivo"));

		return sentenca.toString();
	}
	
	/**
	 * @return String chamando os serviços utilizando Feign (e internamente o Eureka)
	 */
	@RequestMapping("/sentenca/feign")
	public String getSentencaFeign() {
		return palavrasService.getPronome() + palavrasService.getAdjetivo();
	}

	private String getWord(String service) {
		ServiceInstance serverInstance = loadBalancerClient.choose(service);
		if (serverInstance != null) {
			URI uri = serverInstance.getUri();
			if (uri !=null ) {
				return (new RestTemplate()).getForObject(uri+"/palavra",String.class);
			}
		}
		return null;
	}

}
