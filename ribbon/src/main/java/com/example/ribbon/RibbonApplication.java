package com.example.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class RibbonApplication {

	/**
	 * LoadBalanced原理：
	 *      通过实现RestTemplate拦截器实现（ClientHttpRequestInterceptor, HttpRequest）
	 *      https://my.oschina.net/JavaLaw/blog/1553024
	 * @return
	 */
	@Bean(name = "restTemplate")
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	HelloService helloService;
	@RequestMapping(value = "/hi")
	public String hi(@RequestParam String name){
		return helloService.hiService(name);
	}

	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}
}
