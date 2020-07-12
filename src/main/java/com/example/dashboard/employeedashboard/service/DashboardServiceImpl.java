package com.example.dashboard.employeedashboard.service;

import com.example.dashboard.employeedashboard.exception.InvalidInput;
import com.example.dashboard.employeedashboard.model.employee.Employee;
import com.example.dashboard.employeedashboard.model.employee.Title;
import com.example.dashboard.employeedashboard.model.employee.EmployeeDto;
import com.example.dashboard.employeedashboard.repository.EmployeeRepository;
import com.example.dashboard.employeedashboard.service.interfaces.DashboardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void createAccount(EmployeeDto employeeDto) throws InvalidInput {

        if(!employeeDto.getPassword1().equalsIgnoreCase(employeeDto.getPassword2())){
            throw new InvalidInput("Passwords do not match");
        }

        Employee employee = new Employee(employeeDto.getUsername(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getPassword1(), employeeDto.getSalary(), Title.valueOf(employeeDto.getPosition()));
        employeeRepository.save(employee);
        log.debug("New employee is saved {}", employee);
    }
}
