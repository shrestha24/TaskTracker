package com.example.tasktracker.service.implementation;

import com.example.tasktracker.DTO.SignUpRequest;
import com.example.tasktracker.entity.User;
import com.example.tasktracker.enums.Role;
import com.example.tasktracker.repository.UserRepo;
import com.example.tasktracker.service.AuthenticationService;
import jakarta.websocket.server.ServerEndpoint;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImplementation implements AuthenticationService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User signup(SignUpRequest signUpRequest) {
        User user = new User();

        user.setEmail(signUpRequest.getEmail());
        user.setName(signUpRequest.getFirstName());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return userRepo.save(user);
    }
}
