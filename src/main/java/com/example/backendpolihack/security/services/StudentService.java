package com.example.backendpolihack.security.services;

import com.example.backendpolihack.models.Student;
import com.example.backendpolihack.models.User;
import com.example.backendpolihack.models.dto.StudentDto;
import com.example.backendpolihack.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserService userService;

    @Override
    public StudentDto saveStudent(StudentDto student) {
        return null;
        // TODO: Implement the signup logic here
    }

    @Override
    public StudentDto getPersonalDetails(org.springframework.security.core.userdetails.User authUser) {
        User user = userService.getUserByEmail(authUser.getUsername()); // Pentru a scoate rolul
        Student student = studentRepository.findByUserId(user.getId());
        return new StudentDto(student, user);
    }
}
