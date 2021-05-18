package com.service.exhibitservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ExhibitServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExhibitServiceApplication.class, args);
    }

}
