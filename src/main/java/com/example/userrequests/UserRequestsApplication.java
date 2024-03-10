package com.example.userrequests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class UserRequestsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserRequestsApplication.class, args);
    }

}
