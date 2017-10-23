package com.example.ribbon.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Feign客户端，SERVICE-HI是调用的服务器名称，method需要指定
 * @EnableFeignClients 需要开启
 */
@FeignClient("SERVICE-HI")
public interface test {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi(@RequestParam("name") String name);

    @RequestMapping(value = "/object", method = RequestMethod.GET)
    Map<String, Object> object();
}
