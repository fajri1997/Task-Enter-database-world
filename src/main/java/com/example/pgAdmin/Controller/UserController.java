package com.example.pgAdmin.Controller;


import com.example.pgAdmin.bo.CreateUserRequest;
import com.example.pgAdmin.bo.UserResponse;
import com.example.pgAdmin.entity.Status;
import com.example.pgAdmin.entity.UserEntity;
import com.example.pgAdmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }
    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createuser(@RequestBody CreateUserRequest  request) {
        UserResponse response = userService.createUser( request);

        // Check if the response is not null (indicating a successful creation)
        if (response != null) {
            // Return a 201 Created status code along with the created user data
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            // Handle the case where the creation was not successful (e.g., validation failed)
            // You can return a different status code or error message as needed
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @PostMapping("/updateStatus")
    public UserEntity updateUser(@RequestParam(required = false) Long userId, @RequestParam(required = false) String newStatus) {
        List<UserEntity> allUsers = userService.getAllUsers();


        for (UserEntity user : allUsers) {
            if (user.getId().equals(userId)) {
                user.setStatus(newStatus);
                return user;
            }
        }

        return null;
    }



  }
