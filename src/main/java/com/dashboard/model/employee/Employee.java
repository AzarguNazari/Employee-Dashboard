package com.dashboard.model.employee;

import com.dashboard.model.task.Task;
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "task_assign",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    Set<Task> tasks;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    public Employee(){}

    public Employee(String username, String firstName, String lastname, String password, Integer salary, Title title){
        this.username = username;
        this.firstname = firstName;
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
        this.setRoles(employee.getRoles());
    }
}
