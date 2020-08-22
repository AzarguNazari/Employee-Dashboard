package com.dashboard.controller;

import com.dashboard.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface TaskControllerInterface {

    @PostMapping
    ResponseEntity<?> createTask(@RequestBody Task task);

    @GetMapping
    ResponseEntity<?> getAllTasks();

    @GetMapping("/{id}")
    ResponseEntity<?> getTaskById(@PathVariable Integer id);

    @GetMapping("/status/{status}")
    ResponseEntity<?> getTaskByStatus(@PathVariable String status);

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteTaskById(@PathVariable Integer id);

    @PutMapping("/{id}")
    ResponseEntity<?> updateTask(@PathVariable Integer employeeId, @RequestBody Task task);
}
