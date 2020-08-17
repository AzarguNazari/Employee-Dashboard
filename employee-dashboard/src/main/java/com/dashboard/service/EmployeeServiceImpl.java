package com.dashboard.service;

import com.dashboard.model.employee.Employee;
import com.dashboard.model.employee.EmployeeDto;
import com.dashboard.model.employee.Title;
import com.dashboard.repository.EmployeeRepository;
import com.dashboard.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

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
        employeeRepository.save(employee);
    }

    @Override
    public void addNewEmployee(EmployeeDto employee){
        Employee tempEmployee = new Employee(employee.getUsername(), employee.getFirstName(), employee.getLastName(), employee.getPassword1(), employee.getSalary(), Title.valueOf(employee.getPosition()));

//        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees(Pageable pageable){
        return employeeRepository.findAll(pageable).toList();
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
