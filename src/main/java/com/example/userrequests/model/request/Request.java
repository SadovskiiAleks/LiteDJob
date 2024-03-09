package com.example.userrequests.model.request;

import com.example.userrequests.model.status.Status;

public interface Request {
    long getID();
    boolean setStatus(Status status);

    Status getStatus();

    void setID(long id);
}
