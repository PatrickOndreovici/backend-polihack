package com.example.backendpolihack.security.services;

import com.example.backendpolihack.models.dto.TaskDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ITaskService {
       List<TaskDto> getTasks(org.springframework.security.core.userdetails.User authUser) throws Exception;
       TaskDto saveTask(org.springframework.security.core.userdetails.User authUser, TaskDto task) throws Exception;
}
