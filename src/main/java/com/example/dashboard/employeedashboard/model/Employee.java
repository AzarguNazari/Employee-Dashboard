package com.example.dashboard.employeedashboard.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

/**
 * User
 */
@Validated
@Entity
@Data
@Table(name = "dashboard_employee")
public class Employee{

    @JsonProperty
    @Id
    @GeneratedValue
    @JsonIgnore
    private Integer id;

    @JsonProperty
    @Column
    private String firstName;

    @JsonProperty
    @Column
    private String lastName;

    @JsonProperty
    @Column
    private String username;

    @JsonIgnore
    @Column
    private String password;

    @JsonProperty
    @Column
    private Integer salary;

    @JsonProperty
    @Column
    private String position;

    public Employee(){}

    public Employee(String username, String firstName, String lastname, String password, Integer salary, String position){
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastname;
        this.password = password;
        this.salary = salary;
        this.position = position;
    }
}
