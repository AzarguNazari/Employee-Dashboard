package com.dashboard.controller.interfaces;

import com.dashboard.model.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface EmployeeControllerInterface {

    @PostMapping
    ResponseEntity<?> createEmployee(@RequestBody Employee employee);

    @GetMapping
    ResponseEntity<?> getAllEmployees(Pageable pageable);

    @GetMapping("/{id}")
    ResponseEntity<?> getEmployeeById(@PathVariable Integer id);

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteEmployeeById(@PathVariable Integer id);

    @PutMapping("/{id}")
    ResponseEntity<?> updateEmployee(@PathVariable Integer employeeId, @RequestBody Employee employee);

    // Task Operation with Employee
    @PostMapping("/{employeeID}/tasks/{taskID}")
    ResponseEntity<?> assignTask(@PathVariable Integer employeeID, @PathVariable Integer taskID);

    @DeleteMapping("/{employeeID}/tasks/{taskID}")
    ResponseEntity<?> unassignTask(@PathVariable Integer employeeID, @PathVariable Integer taskID);
}
