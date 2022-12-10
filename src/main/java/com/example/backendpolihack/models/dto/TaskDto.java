package com.example.backendpolihack.models.dto;

import com.example.backendpolihack.models.EStatus;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class TaskDto {
    private Long id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private EStatus status;
    private Long studentId;
}
