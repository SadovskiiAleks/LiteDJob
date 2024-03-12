package com.example.userrequests.model.role;

import com.example.userrequests.model.user.MyUser;
import jakarta.persistence.*;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

//public enum Role {
//    ROLE_ADMIN,
//    ROLE_OPERATOR,
//    ROLE_USER
//}
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<MyUser> users;
}