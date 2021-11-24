package com.dashboard.backend.models.dto;

import com.dashboard.backend.models.jpa.Priority;

public record TaskDTO(String taskname, String description, Priority priority, int percentage){}
