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
    public String firstName;
    public String lastName;
    public String email;
    public ERole role;
    public Mentor mentor;
    public Set<Technology> technologies;

    public StudentDto(Student student, User user){
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.role = ERole.STUDENT;
        this.mentor = student.getMentor();
        this.technologies = student.getTechnologies();
    }
}
