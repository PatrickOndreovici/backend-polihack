package com.example.backendpolihack.models.dto;

import com.example.backendpolihack.models.Mentor;
import com.example.backendpolihack.models.User;
import com.example.backendpolihack.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class MentorDto {
    private String firstName;
    private String lastName;
    private String email;

    public MentorDto(User mentor) {
        this.firstName = mentor.getFirstName();
        this.lastName = mentor.getLastName();
        this.email = mentor.getEmail();
    }
}
