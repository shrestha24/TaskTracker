package com.example.tasktracker.repository;

import com.example.tasktracker.entity.User;
import com.example.tasktracker.enums.UserState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    List<User> findAllByStateIn(List<UserState> stateList);
    List<User> findByEmailEndingWith(String email);


}
