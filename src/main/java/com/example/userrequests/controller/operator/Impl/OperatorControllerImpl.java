package com.example.userrequests.controller.operator.Impl;

import com.example.userrequests.controller.operator.OperatorController;
import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.status.Status;
import com.example.userrequests.service.operatorService.OperatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class OperatorControllerImpl implements OperatorController {

    private final OperatorService operatorService;

    @Override
    public ResponseEntity<List<Request>> getAllRequest() {
        return operatorService.getAllRequest();
    }

    @Override
    public ResponseEntity<Request> getRequestByID(long id) {
        return operatorService.getRequestByID(id);
    }

    @Override
    public ResponseEntity<List<Request>> getRequestByName(String name) {
        return operatorService.getRequestByName(name);
    }

    @Override
    public ResponseEntity<String> setStage(long id, Status status) {
        return operatorService.setStage(id, status);
    }
}
