package com.example.tasktracker.service;

import com.example.tasktracker.Exception.NotFoundException;
import com.example.tasktracker.entity.User;
import com.example.tasktracker.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    public final UserRepo userRepo;

    public List<User> getAllTasks(){
        log.info("Getting all users in DB");
        return userRepo.findAll();
    }

    public User getUserById(Long userId){
        Optional<User> optionalUser = userRepo.findById(userId);
        return userRepo.findById(userId).orElseThrow(()-> new RuntimeException("User not found with id" + userId));
    }

    public User updateUser(User user){
        if (!userRepo.existsById(user.getUserId())){
            throw new NotFoundException("Id not present");
        }
        return userRepo.save(user);
    }

    public User createUser(User user){
        return userRepo.save(user);
    }

    public void deleteUser(Long userId){
        if (!userRepo.existsById(userId)){
            throw new RuntimeException("User with id:" +userId+ "not present");
        }
        userRepo.deleteById(userId);
    }


}
