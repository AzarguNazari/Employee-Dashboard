package com.dashboard.service.interfaces;

import com.dashboard.model.Employee;
import com.dashboard.model.EmployeeDto;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInterface {
    void deleteAllEmployees();

    void addAllEmployees(List<Employee> users);

    void addNewEmployee(Employee employee);

    void addNewEmployee(EmployeeDto employee);

    Optional<Employee> getEmployeeById(Integer id);

    List<Employee> getAllEmployees(Pageable pageable);

    Long totalEmployees();

    Optional<Employee> getByUsername(String username);

    void deleteEmployeeById(Integer id);

    void updateEmployee(Integer employeeId, Employee employee);
}
