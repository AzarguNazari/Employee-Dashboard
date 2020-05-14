package com.example.dashboard.employeedashboard.service;

import com.example.dashboard.employeedashboard.model.Task;
import com.example.dashboard.employeedashboard.model.dto.TaskUpdateDTO;
import com.example.dashboard.employeedashboard.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Page<Task> getAllTasks(Pageable pageable){
        return taskRepository.findAll(pageable);
    }

    public void removeTask(int taskID){
        taskRepository.deleteById(taskID);
    }

    public void update(int taskid, TaskUpdateDTO taskUpdated) {
        Optional<Task> task = taskRepository.findById(taskid);
        if(task.isPresent()){
            task.get().setDescription(taskUpdated.getDescription());
            task.get().setPercentage(taskUpdated.getPercentage());
            taskRepository.save(task.get());
            log.debug("task is updated with id " + taskid);
        }
        else {
            log.warn("Task with id " + taskid + " doesn not exist");
        }
    }
}
