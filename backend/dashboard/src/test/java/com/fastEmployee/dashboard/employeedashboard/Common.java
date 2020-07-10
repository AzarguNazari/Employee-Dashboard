package com.fastEmployee.dashboard.employeedashboard;

import com.fastEmployee.dashboard.employeedashboard.model.employee.Employee;
import com.fastEmployee.dashboard.employeedashboard.model.employee.Title;

import java.util.Arrays;
import java.util.List;

public class Common {

    public static List<Employee> loadUser(){

        Employee employee1 = new Employee();
        employee1.setFirstname("firstname1");
        employee1.setLastname("lastname1");
        employee1.setPassword("password1");
        employee1.setTitle(Title.DEVELOPER);
        employee1.setUsername("username1");
        employee1.setSalary(100);



        return Arrays.asList(
             employee1
        );
    }
}
