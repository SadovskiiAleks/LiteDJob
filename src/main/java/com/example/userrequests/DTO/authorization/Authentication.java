package com.example.userrequests.DTO.authorization;

import lombok.Data;

@Data
public class Authentication {

    private String username;

    private String email;

    private String password;
}
