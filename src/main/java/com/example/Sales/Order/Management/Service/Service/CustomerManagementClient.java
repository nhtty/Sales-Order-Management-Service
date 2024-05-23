package com.example.Sales.Order.Management.Service.Service;

import com.example.Sales.Order.Management.Service.Dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomerManagementClient {

    @Autowired
    private RestTemplate restTemplate;

    private static final String url = "http://localhost:8083/customers";

    public ResponseEntity<CustomerDto> getCustomer(String customerid) {
        String fullUrl = url + "/get/" + customerid;
        System.out.println("Calling URL: " + fullUrl);
        return restTemplate.getForEntity(fullUrl, CustomerDto.class);
    }
}

