package com.example.pgAdmin.service;



import com.example.pgAdmin.bo.CreateUserRequest;
import com.example.pgAdmin.bo.UserResponse;
import com.example.pgAdmin.entity.Status;
import com.example.pgAdmin.entity.UserEntity;
import com.example.pgAdmin.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserResponse createUser(CreateUserRequest request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(request.getName());
        userEntity.setStatus(request.getStatus().toString());

        userEntity = userRepository.save(userEntity);
        UserResponse response = new UserResponse(userEntity.getId(), userEntity.getName(), userEntity.getStatus());
        return response;
    }
}