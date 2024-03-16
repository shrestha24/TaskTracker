package com.example.tasktracker.repository;

import com.example.tasktracker.entity.User;
import com.example.tasktracker.enums.Role;
import com.example.tasktracker.enums.UserState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    List<User> findAllByStateIn(List<UserState> stateList);
    List<User> findByEmailEndingWith(String email);

    Optional<User> findByEmail(String email);

    User findByRole(Role role);


}
