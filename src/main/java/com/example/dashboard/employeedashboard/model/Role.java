package com.example.dashboard.employeedashboard.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Validated
@Entity
@Table(name="dashboard_role")
@Data
public class Role{
    @JsonProperty
    @Id
    @GeneratedValue
    @JsonIgnore
    private Integer id;

    @JsonProperty
    @Column
    private String name;

    public Role(){}
    public Role(String roleName){this.name = roleName;}
}

