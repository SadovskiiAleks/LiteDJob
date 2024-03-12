package com.example.userrequests.service.adminService;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.user.MyUser;
import com.example.userrequests.model.role.Role;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    ResponseEntity<List<MyUser>> getAllUsers();

//    ResponseEntity<List<UserRole>> getUsersByName(String name);

    ResponseEntity<Page<Request>> getAllRequest(String sort, Long page);

    ResponseEntity<Page<Request>> getRequestByName(String sort, Long page, String name);

    ResponseEntity<MyUser> setRoleUser(long id, long idRole);
}
