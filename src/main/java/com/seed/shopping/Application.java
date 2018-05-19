package com.seed.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.seed.shopping.config",
    "com.seed.shopping.web.config",
    "com.seed.shopping.bean",
    "com.seed.shopping.service.impl",
    "com.seed.shopping.web.ctrl",
    "com.seed.shopping.rest.server"
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    
}
