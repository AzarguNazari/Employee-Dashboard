package com.dashboard.backend.interfaces.serviceInterfaces;

import com.dashboard.backend.models.jpa.Priority;
import com.dashboard.backend.models.jpa.Task;

import java.util.List;

public interface TaskServiceInterface {

    void deleteAll();

    void addAllTasks(List<Task> tasks);

    Long totalEmployees();

    List<Task> getTaskByPriority(Priority priority);

    List<Task> findTaskByStatus(String status);

    long count();
}
