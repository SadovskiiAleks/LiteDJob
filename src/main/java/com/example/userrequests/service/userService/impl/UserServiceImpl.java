package com.example.userrequests.service.userService.impl;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.status.Status;
import com.example.userrequests.repository.requestRepository.RequestRepository;
import com.example.userrequests.service.userService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RequestRepository requestRepository;

    @Override
    public ResponseEntity<Request> createNewRequest(Request request) {
        request.setStatus(Status.SEND);


        Request newRequest = requestRepository.save(request);
        return new ResponseEntity<>(newRequest, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Request> createNewDraft(Request request) {
        request.setStatus(Status.DRAFT);
        Request newRequest = requestRepository.save(request);
        return new ResponseEntity<>(newRequest, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> sendRequest(long id) {
        Optional<Request> optionalRequest = requestRepository.findById(id);
        //check request
        Request request = optionalRequest.get();
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
        Optional<Request> optionalRequest = requestRepository.findById(id);
        //check request
        Request requestOfRepository = optionalRequest.get();
        if (requestOfRepository.getStatus().equals(Status.DRAFT)) {
//            requestOfRepository. Заполнить все поля с request
            requestOfRepository.setFullText(request.getFullText());
            requestRepository.save(requestOfRepository);
            return ResponseEntity.ok().build();
        } else {
            // add body
            return ResponseEntity.badRequest().build();
        }

    }

    @Override
    public ResponseEntity<List<Request>> getAllRequest() {
        List<Request> arrayList = requestRepository.findAll();
        return new ResponseEntity<>(arrayList, HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<Request>> getAllRequest(String filter) {
        //добавить фильтр
        List<Request> arrayList = requestRepository.findAll();
        return new ResponseEntity<>(arrayList, HttpStatus.FOUND);
    }
}
