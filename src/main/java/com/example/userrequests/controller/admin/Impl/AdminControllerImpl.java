package com.example.userrequests.controller.admin.Impl;

import com.example.userrequests.controller.admin.AdminController;
import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.request.UserRole;
import com.example.userrequests.model.role.Role;
import com.example.userrequests.service.adminService.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class AdminControllerImpl implements AdminController {

    private final AdminService adminService;

    @Override
    public ResponseEntity<List<UserRole>> getAllUsers() {
        return adminService.getAllUsers();
    }

    @Override
    public ResponseEntity<Page<Request>> getAllRequest(String sort, Long page) {
        return adminService.getAllRequest(sort, page);
    }

    @Override
    public ResponseEntity<Page<Request>> getRequestByName(String sort, Long page, String name) {
        return adminService.getRequestByName(sort, page, name);
    }

    @Override
    public ResponseEntity<UserRole> setRoleUser(long id, Role role) {
        return adminService.setRoleUser(id, role);
    }
}
