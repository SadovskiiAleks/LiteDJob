package com.example.userrequests.repository.userRepository;

import com.example.userrequests.model.request.UserRole;

import java.util.ArrayList;

public interface UserRepository {
    ArrayList<UserRepository> getAll();

    ArrayList<UserRepository> getByName(String name);

    UserRole getUser(long id);

    void save(UserRole user);
}
