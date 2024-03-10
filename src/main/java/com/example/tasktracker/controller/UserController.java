package com.example.tasktracker.controller;


import com.example.tasktracker.entity.User;
import com.example.tasktracker.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getAllUsers(){
        List<User> userList = userService.getAllUsers();
        return ResponseEntity.of(Optional.ofNullable(userList));
    }

    @PostMapping("")
    public ResponseEntity<?> createTask(@RequestBody User user){
        User createdUser = userService.createUser(user);
        return ResponseEntity.of(Optional.ofNullable(createdUser));
    }
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable(name = "userId") Long userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }
    @PutMapping("")
    public ResponseEntity<?> updateTask(@RequestBody User user){
        return ResponseEntity.ok(userService.updateUser(user));
    }
    @DeleteMapping("/userId")
    public ResponseEntity<Boolean> deleteUser(@PathVariable(name = "userId") Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok(true);
    }
}
