package br.com.aprendendo.spring.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("EurekaClientPronoun")
public interface ClientPronounRemoteServices {

    @RequestMapping(method = RequestMethod.GET, value = "/word")
    String getPronoun();

}
