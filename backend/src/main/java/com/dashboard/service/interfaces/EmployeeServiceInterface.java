package com.dashboard.service.interfaces;

import com.dashboard.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInterface {
    void deleteAllEmployees();

    void addAllEmployees(List<Employee> users);

    void addNewEmployee(Employee employee);

    Optional<Employee> getEmployeeById(Integer id);

    List<Employee> getAllEmployees();

    Long totalEmployees();

    Optional<Employee> getByUsername(String username);

    void deleteEmployeeById(Integer id);

    void updateEmployee(Integer employeeId, Employee employee);

    void assignTask(Integer employeeId, Integer taskID);

    void unassignTask(Integer employeeId, Integer taskID);
}
