package com.fastEmployee.dashboard.employeedashboard.controller.rest;
import com.fastEmployee.dashboard.employeedashboard.model.task.TaskUpdateDTO;
import com.fastEmployee.dashboard.employeedashboard.service.TaskServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@Slf4j
public class TaskController {

    private final TaskServiceImpl taskServiceImpl;

    public TaskController(TaskServiceImpl taskServiceImpl){
        this.taskServiceImpl = taskServiceImpl;
    }

    @DeleteMapping("/{id}")
    public void removeTask(@PathVariable int id){
        taskServiceImpl.removeTask(id);
        log.warn("task with id " + id + " is remove");
    }

    @PostMapping
    public void getPost(){
        log.warn("getting");
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable int id, @RequestBody TaskUpdateDTO taskUpdated){
        taskServiceImpl.update(id, taskUpdated);
    }

}
