package com.dashboard.backend.models.DTO;

import lombok.Data;

@Data
public class TaskUpdateDTO {
    private String description;
    private int percentage;
}
