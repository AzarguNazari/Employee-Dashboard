package com.dashboard.model.dto;

import com.dashboard.model.Priority;
import lombok.Data;

@Data
public class TaskDTO {
    private String taskname;
    private String description;
    private Priority priority;
    private int percentage;
}
