package com.example.projecttask.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Employee")
@Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode
public class Employee {
    @Id
    private String phoneNumber; //
    @Column(name = "FullName", nullable = false)
    private String fullName;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "Email")
    @Email(message = "Email should be valid")
    private String email;
    @Column(name = "DateOfBirth")
    private LocalDate dateOfBirth;
    @Column(name = "MonthlySalary")
    private Double monthlySalary;

    @ManyToMany
    @JoinTable(
            name = "employee_tasks",
            joinColumns = @JoinColumn(name = "phone_number"))
    private List<Task> taskList;
}
