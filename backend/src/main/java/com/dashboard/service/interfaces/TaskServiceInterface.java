package com.dashboard.service.interfaces;

import com.dashboard.model.Priority;
import com.dashboard.model.Status;
import com.dashboard.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TaskServiceInterface {

    void deleteAllTasks();

    void addAllTasks(List<Task> tasks);

    void addNewTask(Task task);

    Task getTaskById(Integer id);

    List<Task> getAllTasks();

    Long totalEmployees();

    List<Task> getTaskByPriority(Priority priority);

    void deleteTaskById(Integer id);

    void updateTask(Integer employeeId, Task task);

    List<Task> findTaskByStatus(String status);
}
