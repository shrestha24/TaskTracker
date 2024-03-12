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
    @Column(nullable = true)
    @NotBlank(message = "Story points can't be zero")
    @Size(min = 0, max = 100)
    Long storyPoints;
    @Column(nullable = true)
    String assignedUserId;
    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    @NotNull(message = "Task cannot be null")
    TaskState entityState;
    @Column
    @FutureOrPresent(message = "")
    private LocalDateTime startDate;
    @Column
    private LocalDateTime targetDate;
    @CreatedDate
    @Column(name = "createdAt")
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

}
