package com.example.dashboard.employeedashboard;

import com.example.dashboard.employeedashboard.model.Employee;

import java.util.Arrays;
import java.util.List;

public class Common {

    public static List<Employee> loadUser(){
        return Arrays.asList(
                new Employee("username1", "firstname1", "lastname1", "password1", 1000, "position1"),
                new Employee("username2", "firstname2", "lastname2", "password2", 2000, "positoin2"),
                new Employee("username3", "firstname3", "lastname3", "password3", 3000, "position3"),
                new Employee("username4", "firstname4", "lastname4", "password4", 4000, "position4")
        );
    }

}
