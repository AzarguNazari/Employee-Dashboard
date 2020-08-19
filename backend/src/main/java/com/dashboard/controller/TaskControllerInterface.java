package com.dashboard.controller;

import com.dashboard.model.Employee;
import com.dashboard.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TaskControllerInterface {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createTask(@RequestBody Task task);

    @GetMapping
    ResponseEntity<List<Task>> getAllTasks();

    @GetMapping("/{id}")
    ResponseEntity<Task> getTaskById(@PathVariable Integer id);


    @GetMapping("/{status}")
    ResponseEntity<List<Task>> getTaskByStatus(@PathVariable String status);

    @DeleteMapping("/{id}")
    void deleteTaskById(@PathVariable Integer id);

    @PutMapping("/{id}")
    void updateTask(@PathVariable Integer employeeId, @RequestBody Task task);
}
