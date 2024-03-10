package com.example.userrequests.controller.operator.Impl;

import com.example.userrequests.controller.operator.OperatorController;
import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.status.Status;
import com.example.userrequests.service.operatorService.OperatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class OperatorControllerImpl implements OperatorController {

    private final OperatorService operatorService;

    @Override
    public ResponseEntity<Page<Request>> getAllRequest(String sort, Long page) {
        return operatorService.getAllRequest(sort, page);
    }

    @Override
    public ResponseEntity<Request> getRequestByID(long id) {
        return operatorService.getRequestByID(id);
    }

    @Override
    public ResponseEntity<Page<Request>> getRequestByName(String sort, Long page, String name) {
        return operatorService.getRequestByName(sort, page, name);
    }

    @Override
    public ResponseEntity<String> setStage(long id, Status status) {
        return operatorService.setStage(id, status);
    }
}
