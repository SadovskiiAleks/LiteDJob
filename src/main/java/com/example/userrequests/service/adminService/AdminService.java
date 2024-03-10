package com.example.userrequests.service.adminService;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.request.UserRole;
import com.example.userrequests.model.role.Role;
import com.example.userrequests.repository.userRepository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface AdminService {
    ResponseEntity<List<UserRole>> getAllUsers();

    ResponseEntity<List<UserRole>> getUsersByName(String name);

    ResponseEntity<List<Request>> getAllRequest();

    ResponseEntity<List<Request>> getRequestByName(String name);

    ResponseEntity<UserRole> setRoleUser(long id, Role status);
}
