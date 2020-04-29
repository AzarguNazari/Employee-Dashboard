package com.example.dashboard.employeedashboard;

import com.example.dashboard.employeedashboard.model.Employee;
import com.example.dashboard.employeedashboard.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class EmployeeDashboardApplication implements CommandLineRunner{

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeDashboardApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Arrays.asList(
                new Employee("username1", "firstname1","lastname1", "password1", 1000, "developer"),
                new Employee("username2", "firstname2","lastname2", "password2", 2000, "manager"),
                new Employee("username3", "firstname3","lastname3", "password3", 3000, "developer"),
                new Employee("username4", "firstname4","lastname4", "password4", 4000, "manager"),
                new Employee("username5", "firstname5","lastname5", "password5", 5000, "developer")
        )
                .stream()
                .map(employee -> {
                    employeeService.addNewEmployee(employee);
                    return employee;
                }).forEach(System.out::println);

    }
}
