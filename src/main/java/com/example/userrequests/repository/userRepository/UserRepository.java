package com.example.userrequests.repository.userRepository;

import com.example.userrequests.model.request.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserRole,Long> {
    //List<UserRole> findByUsername(String username);

    Optional<UserRole> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
