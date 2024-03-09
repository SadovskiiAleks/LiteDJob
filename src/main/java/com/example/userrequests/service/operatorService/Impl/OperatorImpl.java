package com.example.userrequests.service.operatorService.Impl;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.role.Role;
import com.example.userrequests.model.status.Status;
import com.example.userrequests.repository.requestRepository.RequestRepository;
import com.example.userrequests.service.operatorService.OperatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

@RequiredArgsConstructor
public class OperatorImpl implements OperatorService {

    private final RequestRepository requestRepository;

    @Override
    public ResponseEntity<ArrayList<Request>> getAllRequest() {
        ArrayList<Request> arrayList = requestRepository.getAll(Role.OPERATOR);
        return new ResponseEntity<>(arrayList, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Request> getRequestByID(long id) {
        //add check
        Request arrayList = requestRepository.getByID(id);
        return new ResponseEntity<>(arrayList, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ArrayList<Request>> getRequestByName(String name) {
        ArrayList<Request> arrayList = requestRepository.getByName(name);
        return new ResponseEntity<>(arrayList, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> setStage(long id, Status status) {
        Request requestOfRepository = requestRepository.getRequest(id);
        if (requestOfRepository.getStatus().equals(Status.SEND)) {
            requestOfRepository.setStatus(status);
            requestRepository.save(requestOfRepository);
            return ResponseEntity.ok().build();
        } else {
            // add body
            return ResponseEntity.badRequest().build();
        }
    }
}
