package com.example.userrequests.service.operatorService;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.status.Status;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface OperatorService {
    ResponseEntity<Page<Request>> getAllRequest(String sort, Long page);

    ResponseEntity<Request> getRequestByID(long id);

    ResponseEntity<Page<Request>> getRequestByName(String sort, Long page, String name);

    ResponseEntity<String> setStage(long id, Status status);
}
