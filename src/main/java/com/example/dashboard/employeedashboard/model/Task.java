package com.example.dashboard.employeedashboard.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Validated
@Entity
@Table(name="dashboard_task")
@Data
public class Task{

    @JsonProperty
    @Id
    @GeneratedValue
    @JsonIgnore
    private Integer id;

    @JsonProperty
    @Column(name="name")
    private String name;

    @JsonProperty
    @Column
    private String description;

    @JsonProperty
    @Column
    private Priority priority;

    public Task(){}
    public Task(String name, String description, Priority priority){
        this.name = name;
        this.description = description;
        this.priority = priority;
    }
}

