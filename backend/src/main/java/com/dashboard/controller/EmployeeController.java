package com.dashboard.controller;

import com.dashboard.controller.interfaces.EmployeeControllerInterface;
import com.dashboard.exception.*;
import com.dashboard.model.Employee;
import com.dashboard.service.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
@Tag(name = "Employees")
@Log4j2
public class EmployeeController implements EmployeeControllerInterface {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public ResponseEntity<?> createEmployee(Employee employee) {
        try{
            employeeService.addNewEmployee(employee);
            log.debug("New employee {} is created", employee);
            return new ResponseEntity<>("New employee created", HttpStatus.CREATED);
        }
        catch(BadRequestException ex){
            return new ResponseEntity<>(new ApiError("Employee with id " + employee.getId() + " is already existed", HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getAllEmployees(Pageable pageable) {
        try{
            return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ResponseEntity<?> getEmployeeById(Integer id) {
        try{
            return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> deleteEmployeeById(Integer employeeID) {
        try{
            employeeService.deleteEmployeeById(employeeID);
            log.debug("Employee with id {} is deleted", employeeID);
            return new ResponseEntity<>("Employee with id " + employeeID + " is deleted", HttpStatus.OK);
        }
        catch(EmployeeNotFoundException ex){
            return ExceptionFactory.EMPLOYEE_NOT_FOUND(employeeID);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> updateEmployee(Integer employeeId, Employee employee) {
        try{
            employeeService.updateEmployee(employeeId, employee);
            log.debug("Employee {} is updated", employee);
            return new ResponseEntity<>("Employee with id " + employeeId + " is updated", HttpStatus.OK);
        }
        catch(EmployeeNotFoundException ex){
            return ExceptionFactory.EMPLOYEE_NOT_FOUND(employeeId);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> assignTask(Integer employeeID, Integer taskID) {
        try{
            employeeService.assignTask(employeeID, taskID);
            log.debug("Task {} is assigned to {}", taskID, employeeID);
            return new ResponseEntity<>("Task with ID " + taskID + " is assigned to Employee with ID " + employeeID, HttpStatus.OK);
        }
        catch(TaskNotFoundException ex){
            return ExceptionFactory.TASK_NOT_FOUND(taskID);
        }
        catch(EmployeeNotFoundException ex){
            return ExceptionFactory.EMPLOYEE_NOT_FOUND(employeeID);
        }
        catch(Exception ex){
            return ExceptionFactory.INTERNAL_EXCEPTION();
        }
    }

    @Override
    public ResponseEntity<?> unassignTask(Integer employeeID, Integer taskID) {
        try{
            employeeService.unassignTask(employeeID, taskID);
            log.debug("Task {} is unassigned from to employee {}", taskID, employeeID);
            return new ResponseEntity<>("Task with ID " + taskID + " is assigned to Employee with ID " + employeeID, HttpStatus.OK);
        }
        catch(TaskNotFoundException ex){
            return ExceptionFactory.TASK_NOT_FOUND(taskID);
        }
        catch(EmployeeNotFoundException ex){
            return ExceptionFactory.EMPLOYEE_NOT_FOUND(employeeID);
        }
        catch(Exception ex){
            return ExceptionFactory.INTERNAL_EXCEPTION();
        }
    }
}
