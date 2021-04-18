package com.dashboard.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDto {
    private String username;
    private String password;
}
