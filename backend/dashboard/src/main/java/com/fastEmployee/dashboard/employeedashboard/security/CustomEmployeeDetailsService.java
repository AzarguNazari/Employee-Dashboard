package com.fastEmployee.dashboard.employeedashboard.security;

import com.fastEmployee.dashboard.employeedashboard.model.employee.Employee;
import com.fastEmployee.dashboard.employeedashboard.model.security.CustomEmployeeDetails;
import com.fastEmployee.dashboard.employeedashboard.repository.EmployeeRepository;
import com.fastEmployee.dashboard.employeedashboard.service.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomEmployeeDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> employee = employeeRepository.findByUsername(username);
        employee.orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        return employee.map(CustomEmployeeDetails::new).get();
    }
}

