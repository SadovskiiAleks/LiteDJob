package com.example.userrequests.securityConfig.securityService;

import com.example.userrequests.DTO.authorization.Authentication;
import com.example.userrequests.DTO.authorization.Authorization;
import com.example.userrequests.DTO.authorization.JwtAuthenticationResponse;
import com.example.userrequests.model.user.MyUser;
import com.example.userrequests.model.role.Role;
import com.example.userrequests.repository.roleRepository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;

    public JwtAuthenticationResponse signUp(Authentication request) {
        Role role = new Role();
        var user = MyUser.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roleRepository.findByName("ROLE_USER"))
                .build();
        userService.create(user);
        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }

    public JwtAuthenticationResponse signIn(Authorization request) {
        //exception
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));
        var user = userService
                .userDetailsService()
                .loadUserByUsername(request.getUsername());
        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }
}
