package com.example.tasktracker.entity;


import com.example.tasktracker.enums.TaskState;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Builder
@Data
@Table(name = "task")
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    @NotBlank(message = "Enter the TaskName")
    String taskName;
    @Column(nullable = false)
    @NotBlank(message = "Enter the Task Description")
    String taskDescription;
    @Column(nullable = false)
    @NotNull
    @Size(min = 1, message = "Story points are greater than 0")
    @Size(max = 1000, message = "Story points should be less than 1000")
    Long storyPoints;
    @Column(nullable = true)
    String assignedUserId;
    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    @NotNull(message = "Task cannot be null")
    TaskState entityState;
    @Column
    @FutureOrPresent(message = "Start date should not be null and be greater than targetDate")
    private LocalDateTime startDate;
    @Column
    @FutureOrPresent(message = "Target Date should not be null nad less than start date ")
    private LocalDateTime targetDate;
    @CreatedDate
    @Column(name = "createdAt")
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

}
