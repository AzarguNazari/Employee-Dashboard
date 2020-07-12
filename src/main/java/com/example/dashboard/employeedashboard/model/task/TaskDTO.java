package com.example.dashboard.employeedashboard.model.task;

import lombok.Data;

@Data
public class TaskDTO {
    private String taskname;
    private String description;
    private Priority priority;
    private int percentage;
}
