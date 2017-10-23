package com.example.cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class CliApplication {

	@RequestMapping("/hi")
	public String hi(){
		return "hhhhhh";
	}

	@RequestMapping("/object")
	public Map<String, LocalDate> object(){
		Map<String, LocalDate> d = new HashMap<String, LocalDate>();
		d.put("test", LocalDate.now());
		return d;
	}

	public static void main(String[] args) {
		SpringApplication.run(CliApplication.class, args);
	}
}
