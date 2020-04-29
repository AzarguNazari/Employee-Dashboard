package com.example.dashboard.employeedashboard.restAPI.controller;

import com.example.dashboard.employeedashboard.exception.EmployeeNotFound;
import com.example.dashboard.employeedashboard.model.Employee;
import com.example.dashboard.employeedashboard.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/api/v1/employees")
@RestController
public class EmployeeController implements EmployeeControllerInterface{

    @Autowired
    private EmployeeService employeeService;


    @Override
    public EntityModel<Employee> getAllEmployees(Pageable pageable) {
//        Page<Employee> allEmployees = employeeService.getAllEmployees(pageable);
//        allEmployees.
    }

    @Override
    public ResponseEntity<Employee> getEmployeeById(Integer id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if(employee.isPresent()){
            throw new EmployeeNotFound(id);
        }
        else{

        }
    }

    @Override
    public void deleteEmployeeById() {

    }

    @Override
    public void updateEmployee(Integer employeeId, Employee employee) {

    }
}
