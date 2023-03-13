package com.example.projecttask.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private String assignee;
    private LocalDate dueDate;
}
