package com.dashboard.service.interfaces;

import com.dashboard.model.task.Priority;
import com.dashboard.model.task.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    void deleteAllTasks();

    void addAllTasks(List<Task> tasks);

    void addNewTask(Task task);

    Optional<Task> getTaskById(Integer id);

    Page<Task> getAllTasks(Pageable pageable);

    Long totalEmployees();

    List<Task> getTaskByPriority(Priority priority);

    void deleteTaskById(Integer id);

    void updateTask(Integer employeeId, Task task);
}
