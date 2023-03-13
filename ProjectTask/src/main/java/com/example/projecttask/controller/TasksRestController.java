package com.example.projecttask.controller;

import com.example.projecttask.conversions.TaskConversion;
import com.example.projecttask.dtos.TaskDto;
import com.example.projecttask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tasks")
@CrossOrigin
public class TasksRestController {

    private final TaskService service;

    @Autowired
    public TasksRestController(final TaskService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> findTask(@PathVariable("id") Long id){
        return new ResponseEntity<>(TaskConversion.entityToDto(service.findById(id)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto){
        return new ResponseEntity<>(TaskConversion.entityToDto(service
                .createTask(TaskConversion.dtoToEntity(taskDto))), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable("id") Long id, @RequestBody TaskDto taskDto){
        return new ResponseEntity<>(TaskConversion.entityToDto(service.
                createTask(TaskConversion.dtoToEntity(taskDto))), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long id){
        service.deleteById(id);
    }

}
