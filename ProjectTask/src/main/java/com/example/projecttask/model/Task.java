package com.example.projecttask.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Task")
@Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode
public class Task {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Title", nullable = false)
    private String title;
    @Column(name = "Description")
    private String description;
    @Column(name = "Assignee")
    private String assignee;
    @Column(name = "DueDate")
    private LocalDate dueDate;
}
