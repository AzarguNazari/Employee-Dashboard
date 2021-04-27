package com.dashboard.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Table(name = "employee")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee{

    @Id @GeneratedValue Integer id;

    @Column String firstname;

    @Column String lastname;

    @Column String username;

    @Column String password;

    @Column Integer salary;

    @Enumerated(EnumType.STRING)
    @Column Title title;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "task_assign", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "task_id"))
    Set<Task> tasks;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employee_roles", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "message_employee", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "message_id"))
    private Set<Message> messages;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "attendance_employee", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "attendance_id"))
    private Set<Message> attendance;

    @OneToOne(mappedBy = "employee")
    private User user;

    public Employee(){}

    public Employee(String username, String firstname, String lastname, String password, Integer salary, Title title){
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.salary = salary;
        this.title = title;
    }

    public Employee(Employee employee){
        this.username = employee.getUsername();
        this.firstname = employee.getFirstname();
        this.lastname = employee.getLastname();
        this.password = employee.getPassword();
        this.salary = employee.getSalary();
        this.title = employee.getTitle();
        this.roles = employee.getRoles();
    }
}
