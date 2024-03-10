package com.example.userrequests.controller.user.impl;

import com.example.userrequests.controller.user.UserController;
import com.example.userrequests.model.request.Request;
import com.example.userrequests.service.userService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @Override
    public ResponseEntity<Request> createRequest(Request request, String authorization) {
        return userService.createNewRequest(request, authorization);
    }

    @Override
    public ResponseEntity<Request> createDraft(Request request, String authorization) {
        return userService.createNewDraft(request, authorization);
    }

    @Override
    public ResponseEntity<String> sendRequest(long id, String authorization) {
        return userService.sendRequest(id, authorization);
    }

    @Override
    public ResponseEntity<String> editDraft(long id, Request request, String authorization) {
        return userService.editDraft(id, request, authorization);
    }

    @Override
    public ResponseEntity<Page<Request>> getAllRequest(String authorization, String sort, Long page) {
        return userService.getAllRequest(authorization, sort, page);
    }

//    @Override
//    public ResponseEntity<Page<Request>> getAllRequestFilter(String filter, String authorization, String sort, Long page) {
//        userService.getAllRequest(filter, sort, page);
//        return ResponseEntity.badRequest().build();
//    }
}
