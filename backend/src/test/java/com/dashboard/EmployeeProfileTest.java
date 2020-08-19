package com.dashboard;

import com.dashboard.model.employee.Employee;
import com.dashboard.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Optional;

@SpringBootTest
public class EmployeeProfileTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void findEmployeeByUsername() {

        Optional<Employee> username1 = employeeRepository.findByUsername("username1");
        Assert.isTrue(username1.isPresent(), "Employee exists");
    }

}
