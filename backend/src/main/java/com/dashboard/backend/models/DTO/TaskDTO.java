package com.dashboard.backend.models.DTO;

import com.dashboard.backend.models.JPA.Priority;
import lombok.Data;

@Data
public class TaskDTO {
    private String taskname;
    private String description;
    private Priority priority;
    private int percentage;
}
