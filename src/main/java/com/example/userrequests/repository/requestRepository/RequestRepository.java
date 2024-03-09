package com.example.userrequests.repository.requestRepository;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.role.Role;
import com.example.userrequests.model.status.Status;

import java.util.ArrayList;

public interface RequestRepository {
    Request getRequest(long id);

    ArrayList<Request> getByName(String name);

    Request getByID(long id);

    ArrayList<Request> getAll();

    ArrayList<Request> getAll(Role role);

    void save(Request request);

    Request createNewRequest(Request request);

    ArrayList<Request> getAllWithFilter(Role admin, String name);
}
