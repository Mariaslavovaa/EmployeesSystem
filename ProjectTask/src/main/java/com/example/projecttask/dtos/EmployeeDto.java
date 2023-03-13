package com.example.projecttask.dtos;


import com.example.projecttask.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EmployeeDto {
    private String phoneNumber;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private LocalDate dateOfBirth;
    private Double monthlySalary;

    private List<Task> taskList;
}
