package com.example.Sales.Order.Management.Service.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class SalesConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}


