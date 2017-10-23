package com.example.ribbon.RibbonConfig;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义负载均衡，去掉@Configuration注释启用
 */
//@Configuration
public class MyConfig {

    @Bean
    public IPing getPing(){
        return new MyPing();
    }

    @Bean
    public IRule getRule(){
        return new MyRule();
    }
}
