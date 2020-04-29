package com.example.dashboard.employeedashboard.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.io.Serializable;

@Validated
@Entity
@Table(name="dashboard_role")
@Data
public class Role  implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Id
    @GeneratedValue
    @JsonIgnore
    private Integer id = null;

    @JsonProperty("name")
    @Column(name="name")
    private String name = null;

    public Role(){}
    public Role(String roleName){this.name = roleName;}
}

