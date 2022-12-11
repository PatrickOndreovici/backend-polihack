package com.example.backendpolihack.models.dto;

import com.example.backendpolihack.models.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private String firstName;
    private String lastName;
    private String email;
    private ERole role;
    private MentorDto mentor;
    private Set<Technology> technologies;

    public StudentDto(Student student, User user, User mentorUser){
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.role = ERole.STUDENT;
        this.mentor = new MentorDto(mentorUser);
        this.technologies = student.getTechnologies();
    }
}
