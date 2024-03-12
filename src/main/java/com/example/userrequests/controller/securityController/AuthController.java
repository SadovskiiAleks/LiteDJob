package com.example.userrequests.controller.securityController;

import com.example.userrequests.DTO.authorization.Authentication;
import com.example.userrequests.DTO.authorization.Authorization;
import com.example.userrequests.DTO.authorization.JwtAuthenticationResponse;
import com.example.userrequests.securityConfig.securityService.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody Authentication request) {
        return authenticationService.signUp(request);
    }

    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody Authorization request) {
        return authenticationService.signIn(request);
    }
}
