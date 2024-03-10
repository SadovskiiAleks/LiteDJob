package com.example.userrequests.repository.userRepository;

import com.example.userrequests.model.request.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserRole,Long> {
    List<UserRole> findByName(String name);
}
