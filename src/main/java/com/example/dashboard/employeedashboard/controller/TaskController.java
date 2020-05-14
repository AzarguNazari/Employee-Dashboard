package com.example.dashboard.employeedashboard.controller;
import com.example.dashboard.employeedashboard.model.dto.TaskUpdateDTO;
import com.example.dashboard.employeedashboard.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@Slf4j
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @DeleteMapping("/{id}")
    public void removeTask(@PathVariable int id){
        taskService.removeTask(id);
        log.warn("task with id " + id + " is remove");
    }

    @PostMapping
    public void getPost(){
        log.warn("getting");
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable int id, @RequestBody TaskUpdateDTO taskUpdated){
        taskService.update(id, taskUpdated);
    }

}
