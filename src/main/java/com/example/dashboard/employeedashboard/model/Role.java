package com.example.dashboard.employeedashboard.model;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.List;

@Validated
@Entity
@Table(name="role")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Role{

    @Id
    Integer id;

    @Column
    String name;

    @OneToMany(mappedBy = "role", cascade = {CascadeType.ALL})
    List<Employee> employees;
}

