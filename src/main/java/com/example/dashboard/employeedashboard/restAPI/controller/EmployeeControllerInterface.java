package com.example.dashboard.employeedashboard.restAPI.controller;

import com.example.dashboard.employeedashboard.model.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface EmployeeControllerInterface {
    EntityModel<Employee> getAllEmployees(Pageable pageable);
    ResponseEntity<Employee> getEmployeeById(Integer id);
    void deleteEmployeeById();
    void updateEmployee(Integer employeeId, Employee employee);
}
