package com.dashboard.model;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Validated
@Table(name="role")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Role{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_name")
    private String role;

    public Role(String role){
        this.role = role;
    }
}

