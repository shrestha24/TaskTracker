package com.example.tasktracker;

import com.example.tasktracker.entity.User;
import com.example.tasktracker.enums.Role;
import com.example.tasktracker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing
public class TaskTrackerApplication implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;


    public static void main(String[] args) {
        SpringApplication.run(TaskTrackerApplication.class, args);
    }

    public void run(String... args){
        User adminAccount = userRepo.findByRole(Role.ADMIN);
        if (null == adminAccount){
            User user = new User();

            user.setEmail("admin@gmail.com");
            user.setName("admin");
            user.setRole(Role.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepo.save(user);
        }

    }

}
