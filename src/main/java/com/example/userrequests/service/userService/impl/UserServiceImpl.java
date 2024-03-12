package com.example.userrequests.service.userService.impl;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.user.MyUser;
import com.example.userrequests.model.status.Status;
import com.example.userrequests.repository.requestRepository.RequestRepository;
import com.example.userrequests.repository.userRepository.UserRepository;
import com.example.userrequests.securityConfig.securityService.JwtService;
import com.example.userrequests.service.userService.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public static final String BEARER_PREFIX = "Bearer ";

    private final RequestRepository requestRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Override
    public ResponseEntity<Request> createNewRequest(Request request, String authentication) {
        String token = authentication.substring(BEARER_PREFIX.length());
        Long userId = jwtService.getUserId(token);
        Optional<MyUser> userRoleOptional = userRepository.findById(userId);
        if (userRoleOptional.isPresent()) {
            MyUser myUser = userRoleOptional.get();
            request.setCreated(new Date());
            request.setMyUser(myUser);
            request.setStatus(Status.SEND);
            Request newRequest = requestRepository.save(request);
            return new ResponseEntity<>(newRequest, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Request> createNewDraft(Request request, String authentication) {
        String token = authentication.substring(BEARER_PREFIX.length());
        Long userId = jwtService.getUserId(token);
        Optional<MyUser> userRoleOptional = userRepository.findById(userId);
        if (userRoleOptional.isPresent()) {
            MyUser myUser = userRoleOptional.get();
            if (myUser != null) {
                request.setCreated(new Date());
                request.setMyUser(myUser);
                request.setStatus(Status.DRAFT);
                Request newRequest = requestRepository.save(request);
                return new ResponseEntity<>(newRequest, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> sendRequest(long id, String authentication) {
        String token = authentication.substring(BEARER_PREFIX.length());
        Long userId = jwtService.getUserId(token);
        Optional<Request> optionalRequest = requestRepository.findById(id);
        if (optionalRequest.isPresent()) {
            Request request = optionalRequest.get();
            if (request != null && request.getStatus().equals(Status.DRAFT) && request.getMyUser().getId().equals(userId)) {
                request.setStatus(Status.SEND);
                requestRepository.save(request);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> editDraft(long id, Request request, String authentication) {
        String token = authentication.substring(BEARER_PREFIX.length());
        Long userId = jwtService.getUserId(token);
        Optional<Request> optionalRequest = requestRepository.findById(id);
        if (optionalRequest.isPresent()) {
            Request requestOfRepository = optionalRequest.get();
            if (requestOfRepository.getStatus().equals(Status.DRAFT) && requestOfRepository.getMyUser().getId().equals(userId)) {
                requestOfRepository.setFullText(request.getFullText());
                requestRepository.save(requestOfRepository);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Page<Request>> getAllRequest(String authentication, String sort, Long page) {
        page = page - 1;
        String token = authentication.substring(BEARER_PREFIX.length());
        Long userId = jwtService.getUserId(token);
        Optional<MyUser> userRoleOptional = userRepository.findById(userId);
        if (userRoleOptional.isPresent()) {
            MyUser myUser = userRoleOptional.get();
            if (sort.equals("asc")) {
                Sort sortSQL = Sort.by(Sort.Order.asc("created"));
                PageRequest pageRequest = PageRequest.of(page.intValue(), 5, sortSQL);
                Page<Request> arrayList = requestRepository.findAllByMyUserId(myUser.getId(), pageRequest);
                return new ResponseEntity<>(arrayList, HttpStatus.FOUND);
            }
            if ((sort.equals("desc"))) {
                Sort sortSQL = Sort.by(Sort.Order.desc("created"));
                PageRequest pageRequest = PageRequest.of(page.intValue(), 5, sortSQL);
                Page<Request> arrayList = requestRepository.findAllByMyUserId(myUser.getId(), pageRequest);
                return new ResponseEntity<>(arrayList, HttpStatus.FOUND);
            } else {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

//
//    @Override
//    public ResponseEntity<List<Request>> getAllRequest(String filter, String authentication) {
//        //добавить фильтр
//        List<Request> arrayList = requestRepository.findAll();
//        return new ResponseEntity<>(arrayList, HttpStatus.FOUND);
//    }
}
