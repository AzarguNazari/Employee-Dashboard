package com.example.dashboard.employeedashboard.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password1;
    private String password2;
    private Integer salary;
    private String position;
}
