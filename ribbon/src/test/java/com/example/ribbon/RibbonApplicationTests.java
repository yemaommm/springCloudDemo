package com.example.ribbon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RibbonApplicationTests {

	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void contextLoads() {
		// TODO 访问接口需要验证
		String forObject = restTemplate.postForObject("http://127.0.0.1:8803/refresh", "", String.class);
		System.out.println(forObject);
	}

}
