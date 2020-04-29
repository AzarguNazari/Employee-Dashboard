package com.example.dashboard.employeedashboard.repository;

import com.example.dashboard.employeedashboard.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
