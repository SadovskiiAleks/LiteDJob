package com.example.userrequests.controller.operator;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.status.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operator")
public interface OperatorController {

    @GetMapping("/request")
    ResponseEntity<List<Request>> getAllRequest();

    @GetMapping("/request/{id}")
    ResponseEntity<Request> getRequestByID(@PathVariable(value = "id") long id);

    @GetMapping("/request/filter")
    ResponseEntity<List<Request>> getRequestByName(@RequestBody String name);

    @PutMapping("/request/{id}/setStage")
    ResponseEntity<String> setStage(@PathVariable(value = "id") long id, @RequestBody Status status);
}
