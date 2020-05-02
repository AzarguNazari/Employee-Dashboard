package com.example.dashboard.employeedashboard.repository;

import com.example.dashboard.employeedashboard.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
