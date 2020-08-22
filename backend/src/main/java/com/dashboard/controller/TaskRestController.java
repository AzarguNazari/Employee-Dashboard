package com.dashboard.controller;

import com.dashboard.exception.ApiError;
import com.dashboard.exception.NotFoundException;
import com.dashboard.model.Task;
import com.dashboard.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<?> getAllTasks() {
        try{
            return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getTaskById(Integer id) {
        try{
            return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);
        }
        catch(NotFoundException ex){
            log.debug("account {} is already existed", id);
            return new ResponseEntity<>(new ApiError("account with id " + id + " is doesn't exist", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getTaskByStatus(String status) {
        try{
            return new ResponseEntity<>(taskService.findTaskByStatus(status), HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> deleteTaskById(Integer id) {
        try{
            taskService.deleteTaskById(id);
            return new ResponseEntity<>("Task with id " + id + " is deleted", HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> updateTask(Integer taskID, Task task) {
        try{
            taskService.updateTask(taskID, task);
            return getTaskById(taskID);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
