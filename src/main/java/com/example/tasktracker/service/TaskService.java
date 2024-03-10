package com.example.tasktracker.service;

import com.example.tasktracker.Exception.NotFoundException;
import com.example.tasktracker.entity.Task;
import com.example.tasktracker.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.RuntimeMBeanException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        log.info("Getting all task from DB");
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        Optional<Task> optionalTask=taskRepository.findById(id);
        /*if (optionalTask.isEmpty()){
            throw new NotFoundException("Task not present with  id "+id);
        }*/
        return taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task not found with id"+id));
        //return optionalTask.get();

    }

    /*
    *               Objective : Update Task
    *               Condition : If task exists
    *                               True -> save in repo
    *                               false -> throw Exception
     */
    public Task updateTask(Task task){
        if (!taskRepository.existsById(task.getId())){
            throw new NotFoundException("Id not present");
        }
        return taskRepository.save(task);
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public void deleteTask(Long taskId){
        if (!taskRepository.existsById(taskId)){
            throw new RuntimeException("Task with id:"+taskId+ "not present");
        }
        taskRepository.deleteById(taskId);
    }




}
