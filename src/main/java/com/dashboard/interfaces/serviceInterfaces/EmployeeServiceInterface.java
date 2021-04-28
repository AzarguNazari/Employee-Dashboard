package com.dashboard.interfaces.serviceInterfaces;

import com.dashboard.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInterface {
    void deleteAllEmployees();

    void addAllEmployees(List<Employee> users);

    void addNewEmployee(Employee employee);

    Optional<Employee> getEmployeeById(Integer id);

    List<Employee> getAllEmployees();

    Optional<Employee> getByUsername(String username);

    void deleteById(Integer id);

    void update(Integer employeeId, Employee employee);

    void assignTask(Integer employeeId, Integer taskID);

    void unassignTask(Integer employeeId, Integer taskID);

    boolean exist(Integer employeeId);

    long count();
}
