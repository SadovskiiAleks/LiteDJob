package com.example.userrequests.controller.admin.Impl;

import com.example.userrequests.controller.admin.AdminController;
import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.request.UserRole;
import com.example.userrequests.model.role.Role;
import com.example.userrequests.repository.userRepository.UserRepository;
import com.example.userrequests.service.adminService.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class AdminControllerImpl implements AdminController {

    private final AdminService adminService;

    @Override
    public ResponseEntity<ArrayList<UserRepository>> getAllUsers() {
        return adminService.getAllUsers();
    }

    @Override
    public ResponseEntity<ArrayList<UserRepository>> getUsersByName(String name) {
        return adminService.getUsersByName(name);
    }

    @Override
    public ResponseEntity<ArrayList<Request>> getAllRequest() {
        return adminService.getAllRequest();
    }

    @Override
    public ResponseEntity<ArrayList<Request>> getRequestByName(String name) {
        return adminService.getRequestByName(name);
    }

    @Override
    public ResponseEntity<UserRole> setRoleUser(long id, Role role) {
        return adminService.setRoleUser(id, role);
    }
}
