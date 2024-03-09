package com.example.userrequests.service.operatorService;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.status.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface OperatorService {
    ResponseEntity<ArrayList<Request>> getAllRequest();

    ResponseEntity<Request> getRequestByID(long id);

    ResponseEntity<ArrayList<Request>> getRequestByName(String name);

    ResponseEntity<String> setStage(long id, Status status);
}
