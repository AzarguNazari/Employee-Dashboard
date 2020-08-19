package com.dashboard.controller;

import com.dashboard.model.Employee;
import com.dashboard.exception.EmployeeNotFound;
import com.dashboard.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequestMapping("/api/v1/employees")
@RestController
public class EmployeeRestController implements EmployeeControllerInterface {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void createEmployee(Employee employee) {
        employeeService.addNewEmployee(employee);
    }

    @Override
    public List<EntityModel<Employee>> getAllEmployees(Pageable pageable) {
        return employeeService.getAllEmployees(pageable).stream().map(employee -> getEmployeeById(employee.getId())).collect(Collectors.toList());
    }


    @Override
    public EntityModel<Employee> getEmployeeById(Integer id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);

        if (!employee.isPresent())
            throw new EmployeeNotFound(id);

        EntityModel<Employee> entityModel = new EntityModel<>(employee.get());

        WebMvcLinkBuilder webLinker = linkTo(methodOn(this.getClass()).getAllEmployees(PageRequest.of(1, 10)));

        entityModel.add(webLinker.withRel("all-employees"));

        return entityModel;
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeService.deleteEmployeeById(id);
    }

    @Override
    public void updateEmployee(Integer employeeId, Employee employee) {
        Optional<Employee> foundEmployee = employeeService.getEmployeeById(employeeId);
        if (foundEmployee.isPresent()) {
            employeeService.updateEmployee(employeeId, employee);
        } else {
            throw new EmployeeNotFound(employeeId);
        }
    }
}
