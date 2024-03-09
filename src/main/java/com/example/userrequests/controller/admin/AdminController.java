package com.example.userrequests.controller.admin;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.request.UserRole;
import com.example.userrequests.model.role.Role;
import com.example.userrequests.repository.userRepository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

public interface AdminController {
//    смотреть список пользователей
//• смотреть заявки в статусе отправлено, принято, отклонено. Пагинация 5 элементов, сортировка по дате. Фильтрация по имени.
//• назначать пользователям права оператора

    @GetMapping("/users")
    ResponseEntity<ArrayList<UserRepository>> getAllUsers();

    @GetMapping("/users/filter")
    ResponseEntity<ArrayList<UserRepository>> getUsersByName(@RequestBody String name);

    @GetMapping("/request")
    ResponseEntity<ArrayList<Request>> getAllRequest();

    @GetMapping("/request/filter")
    ResponseEntity<ArrayList<Request>> getRequestByName(@RequestBody String name);

    @PutMapping("/users/{id}")
    ResponseEntity<UserRole> setRoleUser(@PathVariable(value = "id") long id, @RequestBody Role role);
}
