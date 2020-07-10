package com.fastEmployee.dashboard.employeedashboard.model.task;

import com.fastEmployee.dashboard.employeedashboard.model.task.Priority;
import lombok.Data;

@Data
public class TaskDTO {
    private String taskname;
    private String description;
    private Priority priority;
    private int percentage;
}
