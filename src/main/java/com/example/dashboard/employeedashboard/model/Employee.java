package com.example.dashboard.employeedashboard.model;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Data
@Table(name = "employee")
public class Employee{

    @Id @GeneratedValue Integer id;

    @Column String firstname;

    @Column String lastname;

    @Column String username;

    @Column String password;

    @Column Integer salary;

    @Enumerated(EnumType.STRING)
    @Column Title title;

    @ManyToMany
    @JoinTable(
            name = "task_assign",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    Set<Task> tasks;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    Role role;

    public Employee(){}

    public Employee(String username, String firstName, String lastname, String password, Integer salary, Title title){
        this.username = username;
        this.firstname = firstName;
        this.lastname = lastname;
        this.password = password;
        this.salary = salary;
        this.title = title;
    }
}
