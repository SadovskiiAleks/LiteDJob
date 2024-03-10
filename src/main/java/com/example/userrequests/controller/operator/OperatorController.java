package com.example.userrequests.controller.operator;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.status.Status;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operator")
public interface OperatorController {

    @GetMapping("/request/{sort}/{page}")
    ResponseEntity<Page<Request>> getAllRequest(@PathVariable(value = "sort") String sort, @PathVariable(value = "page") Long page);

    @GetMapping("/request/{id}")
    ResponseEntity<Request> getRequestByID(@PathVariable(value = "id") long id);

    @GetMapping("/request/{sort}/{page}/name")
    ResponseEntity<Page<Request>> getRequestByName(@PathVariable(value = "sort") String sort, @PathVariable(value = "page") Long page, @RequestBody String name);

    @PutMapping("/request/{id}/setStage")
    ResponseEntity<String> setStage(@PathVariable(value = "id") long id, @RequestBody Status status);
}
