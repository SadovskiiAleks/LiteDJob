package com.example.userrequests.service.operatorService;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.status.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface OperatorService {
    ResponseEntity<List<Request>> getAllRequest();

    ResponseEntity<Request> getRequestByID(long id);

    ResponseEntity<List<Request>> getRequestByName(String name);

    ResponseEntity<String> setStage(long id, Status status);
}
