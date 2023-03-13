package com.example.projecttask.conversions;

import com.example.projecttask.dtos.TaskDto;
import com.example.projecttask.model.Task;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TaskConversion {
    public static TaskDto entityToDto(Task task){
        return new TaskDto(task.getId(), task.getTitle(), task.getDescription(), task.getAssignee(),
                task.getDueDate());
    }

    public static Task dtoToEntity(TaskDto taskDto){
        return new Task(taskDto.getId(), taskDto.getTitle(), taskDto.getDescription(),
                taskDto.getAssignee(), taskDto.getDueDate());
    }
}
