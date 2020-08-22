package com.dashboard.service;

import com.dashboard.exception.BadRequestException;
import com.dashboard.model.Employee;
import com.dashboard.repository.EmployeeRepository;
import com.dashboard.service.interfaces.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void deleteAllEmployees(){
        employeeRepository.deleteAll();
    }

    @Override
    public void addAllEmployees(List<Employee> users){
        employeeRepository.saveAll(users);
    }

    @Override
    public void addNewEmployee(Employee employee){
        if(employee.getId() != null){
            final Optional<Employee> byId = employeeRepository.findById(employee.getId());
            if(byId.isPresent()) throw new BadRequestException();
        }
        else{
            employeeRepository.save(employee);
        }
    }

    @Override
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Integer id){
        return employeeRepository.findById(id);
    }

    @Override
    public Long totalEmployees(){
        return employeeRepository.count();
    }

    @Override
    public Optional<Employee> getByUsername(String username){
        return employeeRepository.findByUsername(username);
    }

    @Override
    public void deleteEmployeeById(Integer id){
        employeeRepository.deleteById(id);
    }

    @Override
    public void updateEmployee(Integer employeeId, Employee employee) {
        employee.setId(employeeId);
        employeeRepository.deleteById(employeeId);
        employeeRepository.save(employee);
    }

}
