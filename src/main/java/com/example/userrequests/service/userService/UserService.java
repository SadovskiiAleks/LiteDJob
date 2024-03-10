package com.example.userrequests.service.userService;

import com.example.userrequests.model.request.Request;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface UserService {
    ResponseEntity<Request> createNewRequest(Request request);
    ResponseEntity<Request> createNewDraft(Request request);

    ResponseEntity<String> sendRequest(long id);

    ResponseEntity<String> editDraft(long id, Request request);

    ResponseEntity<List<Request>> getAllRequest();
    ResponseEntity<List<Request>> getAllRequest(String filter);


}
