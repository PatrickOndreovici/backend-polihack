package com.example.backendpolihack.models.dto;

import com.example.backendpolihack.models.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    private List<TechnologyDto> technologies;

    public StudentDto(Student student, User user, User mentorUser){
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.role = ERole.STUDENT;
        this.mentor = new MentorDto(mentorUser);
        Set<Technology> technologies = student.getTechnologies();
        List<TechnologyDto> list = new ArrayList<>();
        for (Technology technology : technologies) {
            TechnologyDto technologyDto = new TechnologyDto();
            technologyDto.setName(technology.getName());
            technologyDto.setType(technology.getType());
            technologyDto.setImage(technology.getImage());
            technologyDto.setId(technology.getId());
            list.add(technologyDto);

        }
        this.technologies = list;
    }
}
