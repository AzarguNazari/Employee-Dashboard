package com.dashboard.controller;

import com.dashboard.exception.ApiError;
import com.dashboard.exception.BadRequestException;
import com.dashboard.model.Employee;
import com.dashboard.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeRestController implements EmployeeControllerInterface {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public ResponseEntity<?> createEmployee(Employee employee) {
        try{
            employeeService.addNewEmployee(employee);
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
    public ResponseEntity<?> deleteEmployeeById(Integer id) {
        try{
            employeeService.deleteEmployeeById(id);
            return new ResponseEntity<>("Employee with id " + id + " is deleted", HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> updateEmployee(Integer employeeId, Employee employee) {
        try{
            employeeService.updateEmployee(employeeId, employee);
            return new ResponseEntity<>("Employee with id " + employeeId + " is updated", HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(new ApiError("Internal error happened on backend", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
