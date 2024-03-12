package com.example.userrequests.service.operatorService.Impl;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.status.Status;
import com.example.userrequests.repository.requestRepository.RequestRepository;
import com.example.userrequests.service.operatorService.OperatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OperatorServiceImpl implements OperatorService {

    private final RequestRepository requestRepository;

    @Override
    public ResponseEntity<Page<Request>> getAllRequest(String sort, Long page) {
        page = page - 1;
        if (sort.equals("asc")) {
            Sort sortSQL = Sort.by(Sort.Order.asc("created"));
            PageRequest pageRequest = PageRequest.of(page.intValue(), 5, sortSQL);
            Page<Request> arrayList = requestRepository.findAllByStatus(Status.SEND, pageRequest);
            return new ResponseEntity<>(arrayList, HttpStatus.FOUND);
        }
        if ((sort.equals("desc"))) {
            Sort sortSQL = Sort.by(Sort.Order.desc("created"));
            PageRequest pageRequest = PageRequest.of(page.intValue(), 5, sortSQL);
            Page<Request> arrayList = requestRepository.findAllByStatus(Status.SEND, pageRequest);
            return new ResponseEntity<>(arrayList, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Request> getRequestByID(long id) {
        Optional<Request> optionalRequest = requestRepository.findById(id);
        if (optionalRequest.isPresent()) {
            Request requestOfRepository = optionalRequest.get();
            return new ResponseEntity<>(requestOfRepository, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Page<Request>> getRequestByName(String sort, Long page, String name) {
        page = page - 1;
        if (sort.equals("asc")) {
            Sort sortSQL = Sort.by(Sort.Order.asc("created"));
            PageRequest pageRequest = PageRequest.of(page.intValue(), 5, sortSQL);
            Page<Request> arrayList = requestRepository.findAllByStatusAndMyUserUsernameContaining(Status.SEND, name, pageRequest);
            return new ResponseEntity<>(arrayList, HttpStatus.FOUND);
        }
        if ((sort.equals("desc"))) {
            Sort sortSQL = Sort.by(Sort.Order.desc("created"));
            PageRequest pageRequest = PageRequest.of(page.intValue(), 5, sortSQL);
            Page<Request> arrayList = requestRepository.findAllByStatusAndMyUserUsernameContaining(Status.SEND, name, pageRequest);
            return new ResponseEntity<>(arrayList, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> setStage(long id, Status status) {
        Optional<Request> optionalRequest = requestRepository.findById(id);
        if (optionalRequest.isPresent()) {
            Request requestOfRepository = optionalRequest.get();
            if (requestOfRepository.getStatus().equals(Status.SEND)) {
                if (status.equals(Status.ACCEPT) || status.equals(Status.DISMISS)) {
                    requestOfRepository.setStatus(status);
                    requestRepository.save(requestOfRepository);
                    return ResponseEntity.ok().build();
                } else {
                    return ResponseEntity.badRequest().build();
                }
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
