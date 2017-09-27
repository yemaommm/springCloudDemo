package com.example.ribbon;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class HelloService {

    @Resource(name = "restTemplate")
    RestTemplate rt;

    public String hiService(String name){
        return rt.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
//        return rt.getForObject("http://127.0.0.1:8762/hi?name="+name,String.class);
//        return rt.getForEntity("http://SERVICE-HI/hi?name="+name,String.class).getBody();
    }
}
