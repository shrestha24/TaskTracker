package com.example.tasktracker.repository;

import com.example.tasktracker.entity.Task;
import com.example.tasktracker.enums.TaskState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    // GET ALL TASK THOSE ARE PENDING
    List<Task> findAllByEntityState(TaskState taskEntityState);
    List<Task> findAllByStoryPointsGreaterThanAndEntityState(Long storyPoint, TaskState entityState);

    List<Task> findAllByEntityStateIn(List<TaskState> entityStates);


    List<Task> findAllByCreatedAtBefore(LocalDateTime localDateTime);

    boolean existsById(Long id);



}



/*
            Requirements -> What are those API's?
                            1. X
                            2. y
    Entity -> JPA FUNCTION = SQL QUERY
    SERVICE usko call karega and controller ko fullfill karega

    ENTITY -> JPA FUNCTION -> SERVICE -> CONTROLLER

    select * from db.task where statesIn=${state};
 */
