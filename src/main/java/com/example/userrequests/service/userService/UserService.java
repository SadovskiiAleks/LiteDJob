package com.example.userrequests.service.userService;

import com.example.userrequests.model.request.Request;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface UserService {
    ResponseEntity<Request> createNewRequest(Request request);
    ResponseEntity<Request> createNewDraft(Request request);

    ResponseEntity<String> sendRequest(long id);

    ResponseEntity<String> editDraft(long id, Request request);

    ResponseEntity<ArrayList<Request>> getAllRequest();
    ResponseEntity<ArrayList<Request>> getAllRequest(String filter);


}
