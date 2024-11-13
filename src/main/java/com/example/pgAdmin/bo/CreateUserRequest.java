package com.example.pgAdmin.bo;

import com.example.pgAdmin.entity.Status;
import com.example.pgAdmin.entity.UserEntity;
import org.apache.catalina.Store;



public class CreateUserRequest {
    private String name ;
    private Status status;

     public CreateUserRequest () {
        // Default constructor
    }
    public CreateUserRequest (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }
}

