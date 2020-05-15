package com.example.dashboard.employeedashboard.model.dto;

import com.example.dashboard.employeedashboard.model.Priority;
import lombok.Data;

@Data
public class TaskDTO {
    private String taskname;
    private String description;
    private Priority priority;
    private int percentage;
}
