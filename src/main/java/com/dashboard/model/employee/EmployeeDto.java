package com.dashboard.model.employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
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
