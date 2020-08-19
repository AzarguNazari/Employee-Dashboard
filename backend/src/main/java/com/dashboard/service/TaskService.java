package com.dashboard.service;

import com.dashboard.model.Priority;
import com.dashboard.model.Task;
import com.dashboard.repository.TaskRepository;
import com.dashboard.service.interfaces.TaskServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class TaskService implements TaskServiceInterface {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }

    @Override
    public void addAllTasks(List<Task> tasks) {
        tasks.forEach(taskRepository::save);
    }

    @Override
    public void addNewTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Optional<Task> getTaskById(Integer id) {
        return taskRepository.findById(id);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @Override
    public Long totalEmployees() {
        return taskRepository.count();
    }

    @Override
    public List<Task> getTaskByPriority(Priority priority) {
        return taskRepository.findByPriority(priority.toString());
    }

    @Override
    public void deleteTaskById(Integer id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void updateTask(Integer taskId, Task task) {
        Optional<Task> foundTask = taskRepository.findById(taskId);
        if(foundTask.isPresent()){
            task.setId(taskId);
            taskRepository.deleteById(taskId);
            taskRepository.save(task);
        }
    }

    @Override
    public List<Task> findTaskByStatus(String status) {
        return taskRepository.findByPriority(status);
    }

    public void removeTask(int taskID){
        taskRepository.deleteById(taskID);
    }
}
