package com.example.userrequests.repository.roleRepository;

import com.example.userrequests.model.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {
    List<Role> findByName(String name);
}
