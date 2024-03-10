package com.example.userrequests.service.adminService.Impl;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.request.UserRole;
import com.example.userrequests.model.role.Role;
import com.example.userrequests.model.status.Status;
import com.example.userrequests.repository.requestRepository.RequestRepository;
import com.example.userrequests.repository.userRepository.UserRepository;
import com.example.userrequests.service.adminService.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        return new ResponseEntity<>(arrayList, HttpStatus.OK);
    }

//    @Override
//    public ResponseEntity<List<UserRole>> getUsersByName(String name) {
//        /////!!!!!!!!!!
//        Optional<UserRole> optionalUserRole = userRepository.findByUsername(name);
//        List<UserRole> arrayList = optionalUserRole.stream().toList();
//        return new ResponseEntity<>(arrayList, HttpStatus.OK);
//    }

    @Override
    public ResponseEntity<Page<Request>> getAllRequest(String sort, Long page) {
        page = page - 1;
        if (sort.equals("asc")) {
            Sort sortSQL = Sort.by(Sort.Order.asc("created"));
            PageRequest pageRequest = PageRequest.of(page.intValue(), 5, sortSQL);
            Page<Request> arrayList = requestRepository.findAllByStatusNotLike(Status.DRAFT, pageRequest);
            return new ResponseEntity<>(arrayList, HttpStatus.FOUND);
        }
        if ((sort.equals("desc"))) {
            Sort sortSQL = Sort.by(Sort.Order.desc("created"));
            PageRequest pageRequest = PageRequest.of(page.intValue(), 5, sortSQL);
            Page<Request> arrayList = requestRepository.findAllByStatusNotLike(Status.DRAFT, pageRequest);
            return new ResponseEntity<>(arrayList, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Page<Request>> getRequestByName(String sort, Long page, String name) {
        page = page - 1;
        if (sort.equals("asc")) {
            Sort sortSQL = Sort.by(Sort.Order.asc("created"));
            PageRequest pageRequest = PageRequest.of(page.intValue(), 5, sortSQL);
            Page<Request> arrayList = requestRepository.findAllByStatusNotLikeAndUserRoleUsernameContaining(Status.DRAFT, name, pageRequest);
            return new ResponseEntity<>(arrayList, HttpStatus.FOUND);
        }
        if ((sort.equals("desc"))) {
            Sort sortSQL = Sort.by(Sort.Order.desc("created"));
            PageRequest pageRequest = PageRequest.of(page.intValue(), 5, sortSQL);
            Page<Request> arrayList = requestRepository.findAllByStatusNotLikeAndUserRoleUsernameContaining(Status.DRAFT, name, pageRequest);
            return new ResponseEntity<>(arrayList, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<UserRole> setRoleUser(long id, Role role) {
        Optional<UserRole> optionalUserRole = userRepository.findById(id);
        if (optionalUserRole.isPresent()) {
            //check role
            UserRole user = optionalUserRole.get();
            user.setRole(role);
            return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
