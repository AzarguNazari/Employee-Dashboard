package com.example.dashboard.employeedashboard.repository;

import com.example.dashboard.employeedashboard.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findUserByUsername(String username);
}
