package com.example.pgAdmin.service;

import com.example.pgAdmin.bo.CreateUserRequest;
import com.example.pgAdmin.bo.UserResponse;
import com.example.pgAdmin.entity.Status;
import com.example.pgAdmin.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUsers();

    // Method to create a new user with status handling
    UserResponse createUser(CreateUserRequest request);

    // Method to update a user's status

    // You can define other service methods here as needed
}
