package com.example.dashboard.employeedashboard.restAPI.controller;

import com.example.dashboard.employeedashboard.exception.EmployeeNotFound;
import com.example.dashboard.employeedashboard.model.Employee;
import com.example.dashboard.employeedashboard.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequestMapping("/api/v1/employees")
@RestController
public class EmployeeController{

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);
    }

    @GetMapping
    public List<EntityModel<Employee>> getAllEmployees(Pageable pageable) {
        return employeeService.getAllEmployees(pageable).stream().map(employee -> getEmployeeById(employee.getId())).collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public EntityModel<Employee> getEmployeeById(@PathVariable Integer id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);

        if (!employee.isPresent())
            throw new EmployeeNotFound(id);

        EntityModel<Employee> entityModel = new EntityModel<>(employee.get());

        WebMvcLinkBuilder webLinker = linkTo(methodOn(this.getClass()).getAllEmployees(PageRequest.of(1, 10)));

        entityModel.add(webLinker.withRel("all-employees"));

        return entityModel;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Integer employeeId, @RequestBody Employee employee) {
        Optional<Employee> foundEmployee = employeeService.getEmployeeById(employeeId);
        if(foundEmployee.isPresent()){
            employeeService.updateEmployee(employeeId, employee);
        }
        else{
            throw new EmployeeNotFound(employeeId);
        }
    }
}
