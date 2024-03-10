package com.example.userrequests.controller.admin;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.request.UserRole;
import com.example.userrequests.model.role.Role;
import com.example.userrequests.repository.userRepository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public interface AdminController {

    @GetMapping("/users")
    ResponseEntity<List<UserRole>> getAllUsers();

    @GetMapping("/users/filter")
    ResponseEntity<List<UserRole>> getUsersByName(@RequestBody String name);

    @GetMapping("/request")
    ResponseEntity<List<Request>> getAllRequest();

    @GetMapping("/request/filter")
    ResponseEntity<List<Request>> getRequestByName(@RequestBody String name);

    @PutMapping("/users/{id}")
    ResponseEntity<UserRole> setRoleUser(@PathVariable(value = "id") long id, @RequestBody Role role);
}
