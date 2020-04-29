package com.example.dashboard.employeedashboard.service;

import com.example.dashboard.employeedashboard.model.Employee;
import com.example.dashboard.employeedashboard.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository userRepository){
        this.employeeRepository = userRepository;
    }

    public void addAllEmployees(List<Employee> users){
        employeeRepository.saveAll(users);
    }

    public void addNewEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id){
        return employeeRepository.findById(id).orElse(null);
    }

    public Long totalEmployees(){
        return employeeRepository.count();
    }

    public Employee getEmpoyeeByUsername(String username){
        return employeeRepository.findUserByUsername(username).orElse(null);
    }

    public void deleteEmployeeById(Integer id){
        employeeRepository.deleteById(id);
    }
}
