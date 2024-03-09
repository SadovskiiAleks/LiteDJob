package com.example.userrequests.controller.operator;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.status.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

public interface OperatorController {

    @GetMapping("/request")
    ResponseEntity<ArrayList<Request>> getAllRequest();

    @GetMapping("/request/{id}")
    ResponseEntity<Request> getRequestByID(@PathVariable(value = "id") long id);

    @GetMapping("/request/filter")
    ResponseEntity<ArrayList<Request>> getRequestByName(@RequestBody Status name);

    @GetMapping("/request/{id}/setStage")
    ResponseEntity<String> setStage(@PathVariable(value = "id") long id, @RequestBody Status status);
}
