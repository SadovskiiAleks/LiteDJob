package com.example.userrequests.service.adminService.Impl;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.request.UserRole;
import com.example.userrequests.model.role.Role;
import com.example.userrequests.model.status.Status;
import com.example.userrequests.repository.requestRepository.RequestRepository;
import com.example.userrequests.repository.userRepository.UserRepository;
import com.example.userrequests.service.adminService.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final RequestRepository requestRepository;

    @Override
    public ResponseEntity<ArrayList<UserRepository>> getAllUsers() {
        ArrayList<UserRepository> arrayList = userRepository.getAll();
        return new ResponseEntity<>(arrayList, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ArrayList<UserRepository>> getUsersByName(String name) {
        ArrayList<UserRepository> arrayList = userRepository.getByName(name);
        return new ResponseEntity<>(arrayList, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ArrayList<Request>> getAllRequest() {
        ArrayList<Request> arrayList = requestRepository.getAll(Role.ADMIN);
        return new ResponseEntity<>(arrayList, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ArrayList<Request>> getRequestByName(String name) {
        ArrayList<Request> arrayList = requestRepository.getAllWithFilter(Role.ADMIN, name);
        return new ResponseEntity<>(arrayList, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserRole> setRoleUser(long id, Role role) {
        UserRole user = userRepository.getUser(id);
        user.setRoleUser(role);
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }
}
