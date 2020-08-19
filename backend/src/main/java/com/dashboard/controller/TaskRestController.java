package com.dashboard.controller;

import com.dashboard.model.Task;
import com.dashboard.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/tasks")
@Slf4j
public class TaskRestController implements TaskControllerInterface {

    @Autowired
    private TaskService taskService;

    @Override
    public void createTask(Task task) {
        taskService.addNewTask(task);
        log.debug("New task {} is added", task);
    }

    @Override
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Task> getTaskById(Integer id) {
        final Optional<Task> taskById = taskService.getTaskById(id);
        if(taskById.isPresent()) return new ResponseEntity<>(taskById.get(), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Task>> getTaskByStatus(String status) {
        final List<Task> taskByStatus = taskService.findTaskByStatus(status);
        return new ResponseEntity<>(taskByStatus, HttpStatus.OK);
    }

    @Override
    public void deleteTaskById(Integer id) {
        taskService.deleteTaskById(id);
    }

    @Override
    public void updateTask(Integer taskID, Task task) {
        taskService.updateTask(taskID, task);
    }
}
