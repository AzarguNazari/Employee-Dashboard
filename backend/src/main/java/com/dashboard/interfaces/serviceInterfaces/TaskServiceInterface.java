package com.dashboard.interfaces.serviceInterfaces;

import com.dashboard.model.Priority;
import com.dashboard.model.Task;

import java.util.List;

public interface TaskServiceInterface {

    void deleteAll();

    void addAllTasks(List<Task> tasks);

    void add(Task task);

    Task getTaskById(Integer id);

    List<Task> getAll();

    Long totalEmployees();

    List<Task> getTaskByPriority(Priority priority);

    void deleteTaskById(Integer id);

    void updateTask(Integer employeeId, Task task);

    List<Task> findTaskByStatus(String status);

    boolean exist(Integer taskId);
}
