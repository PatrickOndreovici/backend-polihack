package com.example.backendpolihack.security.services;

import com.example.backendpolihack.models.dto.TaskDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;

public interface ITaskService {
       TaskDto saveTask(org.springframework.security.core.userdetails.User authUser, TaskDto task) throws Exception;
}
