package com.dashboard.backend.interfaces.serviceInterfaces;

import com.dashboard.backend.models.jpa.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInterface {
    void deleteAllEmployees();

    void addAllEmployees(List<Employee> users);

    Optional<Employee> getByUsername(String username);

    void assignTask(Integer employeeId, Integer taskID);

    void unassignTask(Integer employeeId, Integer taskID);

    long count();
}
