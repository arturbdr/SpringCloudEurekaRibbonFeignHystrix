package br.com.aprendendo.spring.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("EurekaClientPronome")
public interface ClientPronomeRemoteServices {

	@RequestMapping(method=RequestMethod.GET, value="/palavra")
	public String getPronome();

}
