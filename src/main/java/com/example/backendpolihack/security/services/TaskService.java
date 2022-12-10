package com.example.backendpolihack.security.services;

import com.example.backendpolihack.models.User;
import com.example.backendpolihack.models.dto.TaskDto;
import com.example.backendpolihack.repository.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;

public class TaskService implements ITaskService{

    private UserRepository userRepository;
    @Override
    @PreAuthorize("hasRole('MENTOR')")
    public TaskDto saveTask(org.springframework.security.core.userdetails.User authUser, TaskDto task) throws Exception {
        User user = userRepository.findByEmail(authUser.getUsername()).orElse(null);
        if (user == null){
            throw new Exception();
        }
        return null;
    }
}
