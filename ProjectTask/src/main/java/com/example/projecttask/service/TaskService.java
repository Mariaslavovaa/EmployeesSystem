package com.example.projecttask.service;

import com.example.projecttask.model.Task;

public interface TaskService {

    Task createTask(Task task);
    Task findById(Long id);
    Task updateTask(Task task);
    void deleteById(Long id);
}
