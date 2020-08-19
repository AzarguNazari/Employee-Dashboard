package com.dashboard.controller.rest;
import com.dashboard.model.task.TaskUpdateDTO;
import com.dashboard.service.TaskServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@Slf4j
public class TaskRestController {

    private final TaskServiceImpl taskServiceImpl;

    public TaskRestController(TaskServiceImpl taskServiceImpl){
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
        taskServiceImpl.updateTask(id, null);
    }

}
