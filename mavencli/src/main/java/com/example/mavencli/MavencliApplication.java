package com.example.mavencli;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.SerializationConfig;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class MavencliApplication {

//	@Value("${server.port}")
//	String port;
	@RequestMapping("/hi")
	public String home(@RequestParam String name) {
		return "hi "+name+",i am from port:";
	}

	public static void main(String[] args) {
		SpringApplication.run(MavencliApplication.class, args);
	}
}
