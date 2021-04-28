package com.dashboard.models.dto;

import lombok.Data;

@Data
public class TaskUpdateDTO {
    private String description;
    private int percentage;
}
