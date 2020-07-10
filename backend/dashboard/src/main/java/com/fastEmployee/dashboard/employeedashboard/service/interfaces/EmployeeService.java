package com.fastEmployee.dashboard.employeedashboard.service.interfaces;

import com.fastEmployee.dashboard.employeedashboard.model.employee.Employee;
import com.fastEmployee.dashboard.employeedashboard.model.employee.EmployeeDto;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
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
