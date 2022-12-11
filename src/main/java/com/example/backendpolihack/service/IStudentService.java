package com.example.backendpolihack.service;

import com.example.backendpolihack.models.dto.StudentDto;

public interface IStudentService {
    StudentDto saveStudent(StudentDto student);
    StudentDto getPersonalDetails(org.springframework.security.core.userdetails.User authUser);
}
