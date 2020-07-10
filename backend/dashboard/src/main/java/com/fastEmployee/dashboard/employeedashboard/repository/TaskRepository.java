package com.fastEmployee.dashboard.employeedashboard.repository;

import com.fastEmployee.dashboard.employeedashboard.model.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByPriority(String priority);
}
