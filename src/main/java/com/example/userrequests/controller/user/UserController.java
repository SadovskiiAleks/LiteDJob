package com.example.userrequests.controller.user;

import com.example.userrequests.model.request.Request;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/user")
@RequestMapping("/user")
public interface UserController {

    //Create request
    @PostMapping("/request")
    ResponseEntity<Request> createRequest(@RequestBody Request request);

    //Create draft
    @PostMapping("/draft")
    ResponseEntity<Request> createDraft(@RequestBody Request request);

    //Send request
    @PutMapping("/send/{id}")
    ResponseEntity<String> sendRequest(@PathVariable(value = "id") long id);

    //Edit draft
    @PutMapping("/draft/{id}")
    ResponseEntity<String> editDraft(@PathVariable(value = "id") long id, @RequestBody Request request);

    //Show all Request
    @GetMapping("/request")
    ResponseEntity<List<Request>> getAllRequest();


    //Show all Request with filter
    @GetMapping("/request/{filter}")
    ResponseEntity<List<Request>> getAllRequestFilter(@PathVariable(value = "filter") String filter);


}
