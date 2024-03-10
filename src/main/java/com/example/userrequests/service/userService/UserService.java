package com.example.userrequests.service.userService;

import com.example.userrequests.model.request.Request;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface UserService {
    ResponseEntity<Request> createNewRequest(Request request, String authentication);
    ResponseEntity<Request> createNewDraft(Request request, String authentication);

    ResponseEntity<String> sendRequest(long id, String authentication);

    ResponseEntity<String> editDraft(long id, Request request, String authentication);

    ResponseEntity<Page<Request>> getAllRequest(String authentication, String sort, Long page);
//    ResponseEntity<List<Request>> getAllRequest(String filter, String authentication);


}
