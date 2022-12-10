package com.example.backendpolihack.security.services;

import com.example.backendpolihack.models.dto.TaskDto;

public interface ITaskService {
    TaskDto saveTask(TaskDto task);
}
