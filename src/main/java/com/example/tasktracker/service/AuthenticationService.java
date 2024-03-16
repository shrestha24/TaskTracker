package com.example.tasktracker.service;

import com.example.tasktracker.DTO.SignUpRequest;
import com.example.tasktracker.entity.User;

public interface AuthenticationService {

    User signup(SignUpRequest signUpRequest);
}
