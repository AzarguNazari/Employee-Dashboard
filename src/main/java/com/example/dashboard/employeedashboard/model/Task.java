package com.example.dashboard.employeedashboard.model;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.Set;

@Validated
@Entity
@Table(name="task")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Task{

    @Id
    @GeneratedValue
    private Integer id;

    @Column @NonNull
    private String taskname;

    @Column @NonNull
    private String description;

    @Column @NonNull @Enumerated(EnumType.STRING)
    private Priority priority;

    @ManyToMany(mappedBy = "tasks")
    private Set<Employee> assignedTo;
}

