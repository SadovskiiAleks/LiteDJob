package com.example.userrequests.service.userService.impl;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.status.Status;
import com.example.userrequests.repository.requestRepository.RequestRepository;
import com.example.userrequests.service.userService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RequestRepository requestRepository;

    @Override
    public ResponseEntity<Request> createNewRequest(Request request) {
        request.setStatus(Status.SEND);
        Request newRequest = requestRepository.createNewRequest(request);
        return new ResponseEntity<>(newRequest, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Request> createNewDraft(Request request) {
        request.setStatus(Status.DRAFT);
        Request newRequest = requestRepository.createNewRequest(request);
        return new ResponseEntity<>(newRequest, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> sendRequest(long id) {
        //прописать логику
        Request request = requestRepository.getRequest(id);
        if (request.getStatus().equals(Status.DRAFT)) {
            request.setStatus(Status.SEND);
            requestRepository.save(request);
            return ResponseEntity.ok().build();
        } else {
            // add body
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<String> editDraft(long id, Request request) {
        Request requestOfRepository = requestRepository.getRequest(id);

        if (requestOfRepository.getStatus().equals(Status.DRAFT)) {
//            requestOfRepository. Заполнить все поля с request
            requestRepository.save(request);
            return ResponseEntity.ok().build();
        } else {
            // add body
            return ResponseEntity.badRequest().build();
        }

    }

    @Override
    public ResponseEntity<ArrayList<Request>> getAllRequest() {
        ArrayList<Request> arrayList = requestRepository.getAll();
        return new ResponseEntity<>(arrayList, HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<ArrayList<Request>> getAllRequest(String filter) {
        //добавить фильтр
        ArrayList<Request> arrayList = requestRepository.getAll();
        return new ResponseEntity<>(arrayList, HttpStatus.FOUND);
    }
}
