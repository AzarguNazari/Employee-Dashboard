package com.example.dashboard.employeedashboard.service;

import com.example.dashboard.employeedashboard.model.Employee;
import com.example.dashboard.employeedashboard.repository.EmployeeRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Employee> getAllEmployees(Pageable pageable){
        return employeeRepository.findAll(pageable).toList();
    }

    public Optional<Employee> getEmployeeById(Integer id){
        return employeeRepository.findById(id);
    }

    public Long totalEmployees(){
        return employeeRepository.count();
    }

    public Optional<Employee> getEmpoyeeByUsername(String username){
        return employeeRepository.findUserByUsername(username);
    }

    public void deleteEmployeeById(Integer id){
        employeeRepository.deleteById(id);
    }

    public void updateEmployee(Integer employeeId, Employee employee) {
        employee.setId(employeeId);
        employeeRepository.deleteById(employeeId);
        employeeRepository.save(employee);
    }

}
