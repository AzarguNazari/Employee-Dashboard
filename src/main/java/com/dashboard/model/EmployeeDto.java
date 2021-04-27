package com.dashboard.model;

import lombok.*;

@Data
@NoArgsConstructor
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password1;
    private String password2;
    private Integer salary;
    private String position;
}
