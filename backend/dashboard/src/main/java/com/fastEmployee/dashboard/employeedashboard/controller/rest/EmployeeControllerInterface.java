package com.fastEmployee.dashboard.employeedashboard.controller.rest;

import com.fastEmployee.dashboard.employeedashboard.model.employee.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface EmployeeControllerInterface {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createEmployee(@RequestBody Employee employee);

    @GetMapping
    List<EntityModel<Employee>> getAllEmployees(Pageable pageable);

    @GetMapping("/{id}")
    EntityModel<Employee> getEmployeeById(@PathVariable Integer id);

    @DeleteMapping("/{id}")
    void deleteEmployeeById(@PathVariable Integer id);

    @PutMapping("/{id}")
    void updateEmployee(@PathVariable Integer employeeId, @RequestBody Employee employee);
}
