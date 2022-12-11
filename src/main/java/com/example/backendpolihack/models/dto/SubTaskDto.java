package com.example.backendpolihack.models.dto;

import com.example.backendpolihack.models.SubTask;
import lombok.Data;

@Data
public class SubTaskDto {
    private int id;
    private String name;
    private String description;
    private boolean isDone;

    public SubTaskDto(SubTask subTask){
        this.id = subTask.getId();
        this.name = subTask.getName();
        this.description = subTask.getDescription();
        this.isDone = subTask.isDone();
    }
}
