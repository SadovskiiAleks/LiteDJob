package com.example.userrequests.controller.admin;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.user.MyUser;
import com.example.userrequests.model.role.Role;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public interface AdminController {

    @GetMapping("/users")
    ResponseEntity<List<MyUser>> getAllUsers();
//
//    @GetMapping("/users/filter")
//    ResponseEntity<List<UserRole>> getUsersByName(@RequestBody String name);

    @GetMapping("/request/{sort}/{page}")
    ResponseEntity<Page<Request>> getAllRequest(@PathVariable(value = "sort") String sort, @PathVariable(value = "page") Long page);

    @GetMapping("/request/{sort}/{page}/name")
    ResponseEntity<Page<Request>> getRequestByName(@PathVariable(value = "sort") String sort, @PathVariable(value = "page") Long page,
                                                   @RequestBody String name);

    @PutMapping("/users/{id}")
    ResponseEntity<MyUser> setRoleUser(@PathVariable(value = "id") long id, @RequestBody long idRole);
}
