package com.dashboard.models.dto;

import com.dashboard.models.Priority;
import lombok.Data;

@Data
public class TaskDTO {
    private String taskname;
    private String description;
    private Priority priority;
    private int percentage;
}
