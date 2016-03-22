package br.com.aprendendo.spring.cloud.eureka.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTeste {
	
	@RequestMapping("/ok")
	public String ok(){
		return "okok";
	}
}
