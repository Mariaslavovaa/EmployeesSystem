package com.example.projecttask.service;

import com.example.projecttask.model.Task;
import com.example.projecttask.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImplementation implements TaskService{

    private final TaskRepository repository;

    @Autowired
    public TaskServiceImplementation(final TaskRepository repository) { this.repository = repository; }

    @Override
    public Task createTask(Task task) {
        if (task == null){
            throw new IllegalArgumentException("Task cannot be null!");
        }
        return repository.save(task);
    }

    @Override
    public Task findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Could not find this task"));
    }

    @Override
    public Task updateTask(Task task) { return repository.save(task); }

    @Override
    public void deleteById(Long id) { repository.deleteById(id); }
}
