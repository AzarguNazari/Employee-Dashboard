package com.dashboard.models.DTO;

import com.dashboard.models.JPA.Priority;
import lombok.Data;

@Data
public class TaskDTO {
    private String taskname;
    private String description;
    private Priority priority;
    private int percentage;
}
