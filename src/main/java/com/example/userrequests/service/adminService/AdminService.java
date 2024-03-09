package com.example.userrequests.service.adminService;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.request.UserRole;
import com.example.userrequests.model.role.Role;
import com.example.userrequests.model.status.Status;
import com.example.userrequests.repository.userRepository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface AdminService {
    ResponseEntity<ArrayList<UserRepository>> getAllUsers();

    ResponseEntity<ArrayList<UserRepository>> getUsersByName(String name);

    ResponseEntity<ArrayList<Request>> getAllRequest();

    ResponseEntity<ArrayList<Request>> getRequestByName(String name);

    ResponseEntity<UserRole> setRoleUser(long id, Role status);
}
