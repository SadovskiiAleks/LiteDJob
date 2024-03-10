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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final RequestRepository requestRepository;

    @Override
    public ResponseEntity<List<UserRole>> getAllUsers() {
        List<UserRole> list = userRepository.findAll();
        ArrayList<UserRole> arrayList = new ArrayList<>();
        arrayList.addAll(list);
        return new ResponseEntity<>(arrayList, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<UserRole>> getUsersByName(String name) {
        List<UserRole> arrayList = userRepository.findByName(name);
        return new ResponseEntity<>(arrayList, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Request>> getAllRequest() {
        List<Request> arrayList = requestRepository.findAllByStatusOrStatusOrStatus(Status.SEND,Status.ACCEPT,Status.DISMISS);
        return new ResponseEntity<>(arrayList, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Request>> getRequestByName(String name) {
        List<Request> arrayList = requestRepository.findAllByUserRoleNameAndStatusOrStatusOrStatus(name,Status.DRAFT,Status.DISMISS,Status.ACCEPT);
        return new ResponseEntity<>(arrayList, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserRole> setRoleUser(long id, Role role) {
        Optional<UserRole> optionalUserRole = userRepository.findById(id);
        UserRole user = optionalUserRole.get();
        user.setRole(role);
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }
}
