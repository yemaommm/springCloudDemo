package com.example.ribbon;

import com.example.ribbon.service.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableFeignClients
@RestController
@RefreshScope //注解@RefreshScope指示Config客户端在服务器配置改变时，也刷新注入的属性值
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
	private test hs;

	@Autowired
	HelloService helloService;

	@RequestMapping(value = "/hi")
	public String hi(@RequestParam String name){
		return helloService.hiService(name);
	}

    @RequestMapping(value = "/hi2")
    public String hi2(@RequestParam String name){
        return hs.hi(name);
    }

    @RequestMapping(value = "/object")
    public Map<String, Object> object(){
        return hs.object();
    }

    @Value("${test.name}")
    private String testName;

    @RequestMapping(value = "/testConfig")
    public String testConfig(){
        return "test.name: " + testName;
    }

	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}
}
