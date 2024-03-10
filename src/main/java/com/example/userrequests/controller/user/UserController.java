package com.example.userrequests.controller.user;

import com.example.userrequests.DTO.authorization.Authorization;
import com.example.userrequests.model.request.Request;
import org.springframework.data.domain.Page;
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
    ResponseEntity<Request> createRequest(@RequestBody Request request, @RequestHeader String authorization);

    //Create draft
    @PostMapping("/draft")
    ResponseEntity<Request> createDraft(@RequestBody Request request, @RequestHeader String authorization);

    //Send request
    @PutMapping("/send/{id}")
    ResponseEntity<String> sendRequest(@PathVariable(value = "id") long id, @RequestHeader String authorization);

    //Edit draft
    @PutMapping("/draft/{id}")
    ResponseEntity<String> editDraft(@PathVariable(value = "id") long id, @RequestBody Request request, @RequestHeader String authorization);

    //Show all Request
    @GetMapping("/request/{sort}/{page}")
    ResponseEntity<Page<Request>> getAllRequest(@RequestHeader String authorization, @PathVariable(value = "sort") String sort, @PathVariable(value = "page") Long page);


//    //Show all Request with filter
//    @GetMapping("/request/{filter}")
//    ResponseEntity<Page<Request>> getAllRequestFilter(@PathVariable(value = "filter") String filter, @RequestHeader String authorization, @PathVariable(value = "sort") String sort, @PathVariable(value = "page") long page);


}
