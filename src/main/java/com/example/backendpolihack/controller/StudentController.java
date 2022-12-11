package com.example.backendpolihack.controller;

import com.example.backendpolihack.models.dto.StudentDto;
import com.example.backendpolihack.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/me")
    @PreAuthorize("hasRole('STUDENT')")
    public StudentDto me(@AuthenticationPrincipal org.springframework.security.core.userdetails.User user) {
        return studentService.getPersonalDetails(user);
    }
}
