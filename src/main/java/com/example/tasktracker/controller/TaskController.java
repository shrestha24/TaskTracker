package com.example.tasktracker.controller;

import com.example.tasktracker.entity.Task;
import com.example.tasktracker.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1/task")
public class TaskController{
    private final TaskService taskService;

    @GetMapping("")
    public ResponseEntity<?> getAllTask(){
        System.out.println("Welcome");
        List<Task> taskList=taskService.getAllTasks();
        return ResponseEntity.of(Optional.ofNullable(taskList));
    }

    @PostMapping("")
    public ResponseEntity<?> createTask(@Valid @RequestBody Task task){
        Task createdTask=taskService.createTask(task);
        return ResponseEntity.of(Optional.ofNullable(createdTask));
    }
    @GetMapping("/{taskId}")
    public ResponseEntity<?> getTaskById(@PathVariable(name = "taskId")Long taskId){
        return ResponseEntity.ok(taskService.getTaskById(taskId));
    }

    @PutMapping("")
    public ResponseEntity<?> updateTask(@RequestBody Task task){
        return ResponseEntity.ok(taskService.updateTask(task));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable(name = "taskId") Long taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.ok(true);
    }



}
