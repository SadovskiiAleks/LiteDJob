package com.example.userrequests.controller.user.impl;

import com.example.userrequests.controller.user.UserController;
import com.example.userrequests.model.request.Request;
import com.example.userrequests.service.userService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @Override
    public ResponseEntity<Request> createRequest(Request request) {
        return userService.createNewRequest(request);
    }

    @Override
    public ResponseEntity<Request> createDraft(Request request) {
        return userService.createNewDraft(request);
    }

    @Override
    public ResponseEntity<String> sendRequest(long id) {
        return userService.sendRequest(id);
    }

    @Override
    public ResponseEntity<String> editDraft(long id, Request request) {
        return userService.editDraft(id, request);
    }

    @Override
    public ResponseEntity<ArrayList<Request>> getAllRequest() {
        return userService.getAllRequest();
    }

    @Override
    public ResponseEntity<String> getAllRequestFilter() {
        String filter=new String();
        userService.getAllRequest( filter);
         return ResponseEntity.badRequest().build();
    }
}
