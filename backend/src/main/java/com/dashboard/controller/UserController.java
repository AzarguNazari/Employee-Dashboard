package com.dashboard.controller;

import com.dashboard.controller.interfaces.EmployeeControllerInterface;
import com.dashboard.exception.*;
import com.dashboard.model.Employee;
import com.dashboard.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@Log4j2
public class UserController implements EmployeeControllerInterface {


    @Override
    public ResponseEntity<?> createEmployee(Employee employee) {
        return null;
    }

    @Override
    public ResponseEntity<?> getAllEmployees(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<?> getEmployeeById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteEmployeeById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateEmployee(Integer employeeId, Employee employee) {
        return null;
    }

    @Override
    public ResponseEntity<?> assignTask(Integer employeeID, Integer taskID) {
        return null;
    }

    @Override
    public ResponseEntity<?> unassignTask(Integer employeeID, Integer taskID) {
        return null;
    }
}
