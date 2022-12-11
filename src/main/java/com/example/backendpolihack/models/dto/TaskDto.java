package com.example.backendpolihack.models.dto;

import com.example.backendpolihack.models.EStatus;
import com.example.backendpolihack.models.SubTask;
import com.example.backendpolihack.models.Task;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class TaskDto {
    private Long id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private EStatus status;
    private Long studentId;
    List<SubTaskDto> subTasks;


    public TaskDto(Task task){
        this.id = task.getId();
        this.name = task.getName();
        this.description = task.getDescription();
        this.status = task.getStatus();
        this.studentId = task.getStudent().getId();
        List<SubTaskDto> subTaskList = new ArrayList<>();
        for (SubTask subTask : task.getSubTasks()){
            subTaskList.add(new SubTaskDto(subTask));
        }
        this.subTasks = subTaskList;
    }

}
