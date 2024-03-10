package com.example.tasktracker.entity;


import com.example.tasktracker.enums.TaskState;
import jakarta.persistence.*;
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
    String taskName;
    @Column(nullable = false)
    String taskDescription;
    @Column(nullable = true)
    Long storyPoints;
    @Column(nullable = true)
    String assignedUserId;
    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    TaskState entityState;
    @Column
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
