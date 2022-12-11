package com.example.backendpolihack.controller;

import com.example.backendpolihack.models.dto.TaskDto;
import com.example.backendpolihack.service.ITaskService;
import com.example.backendpolihack.service.IUserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private IUserService userService;
    private ITaskService taskService;

//    public TaskDto saveTask(@AuthenticationPrincipal org.springframework.security.core.userdetails.User authUser,
//                            @RequestBody TaskDto task) throws Exception {
//        return taskService.saveTask(authUser, task);
//    }
    @GetMapping()
    public List<TaskDto> getTasks(@AuthenticationPrincipal User authUser) throws Exception {
        return taskService.getTasks(authUser);
    }

    @PatchMapping()
    public TaskDto updateTask(@AuthenticationPrincipal User authUser, TaskDto taskDto){
        return taskService.updateTask(authUser, taskDto);
    }
}
