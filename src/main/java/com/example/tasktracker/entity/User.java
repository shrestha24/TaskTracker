package com.example.tasktracker.entity;

import com.example.tasktracker.enums.UserState;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "t_User")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;
    @Column(nullable = false)
    @NotBlank(message = "Enter the name" )
    String name;
    @Column(nullable = false)
    @Email(message = "Enter a valid email")
    String email;
    @Column(nullable = false)
    @NotBlank(message = "Enter a valid phoneNo.")
    String phone;
    @NotBlank(message = "Mention the status")
    @Column(name = "state")
    UserState state;
}