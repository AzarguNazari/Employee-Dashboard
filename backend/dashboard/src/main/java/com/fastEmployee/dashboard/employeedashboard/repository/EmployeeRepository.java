package com.fastEmployee.dashboard.employeedashboard.repository;

import com.fastEmployee.dashboard.employeedashboard.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByUsername(String username);
}
