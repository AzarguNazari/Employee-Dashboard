package com.dashboard.service;

import com.dashboard.model.task.Priority;
import com.dashboard.model.task.Task;
import com.dashboard.repository.TaskRepository;
import com.dashboard.service.interfaces.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class TaskServiceImpl implements TaskService {

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

    public Page<Task> getAllTasks(Pageable pageable){
        return taskRepository.findAll(pageable);
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

    public void removeTask(int taskID){
        taskRepository.deleteById(taskID);
    }
}
