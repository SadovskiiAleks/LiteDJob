package com.example.userrequests.service.operatorService.Impl;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.role.Role;
import com.example.userrequests.model.status.Status;
import com.example.userrequests.repository.requestRepository.RequestRepository;
import com.example.userrequests.service.operatorService.OperatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OperatorServiceImpl implements OperatorService {

    private final RequestRepository requestRepository;

    @Override
    public ResponseEntity<List<Request>> getAllRequest() {
        List<Request> arrayList = requestRepository.findAllByStatus(Status.SEND);
        return new ResponseEntity<>(arrayList, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Request> getRequestByID(long id) {
        //add check
        Optional<Request> optionalRequest = requestRepository.findById(id);
        Request requestOfRepository = optionalRequest.get();
        return new ResponseEntity<>(requestOfRepository, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Request>> getRequestByName(String name) {
        System.out.println(name);
        List<Request> arrayList = requestRepository.findAllByUserRoleName(name);
        return new ResponseEntity<>(arrayList, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> setStage(long id, Status status) {
        Optional<Request> optionalRequest = requestRepository.findById(id);
        Request requestOfRepository = optionalRequest.get();
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
