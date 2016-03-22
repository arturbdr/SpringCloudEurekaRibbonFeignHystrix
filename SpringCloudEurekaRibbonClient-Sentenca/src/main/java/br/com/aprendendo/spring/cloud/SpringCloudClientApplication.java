package br.com.aprendendo.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
public class SpringCloudClientApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudClientApplication.class, args);
	}
}
