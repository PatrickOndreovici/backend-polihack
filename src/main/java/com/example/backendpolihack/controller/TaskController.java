package com.example.backendpolihack.controller;

import com.example.backendpolihack.models.User;
import com.example.backendpolihack.models.dto.TaskDto;
import com.example.backendpolihack.security.services.IUserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    private IUserService userService;

    public TaskDto saveTask(@AuthenticationPrincipal org.springframework.security.core.userdetails.User user){
        return null;
    }
}
