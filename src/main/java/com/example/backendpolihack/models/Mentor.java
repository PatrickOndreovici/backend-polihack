package com.example.backendpolihack.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mentors")
public class Mentor {
    @Id
    private Long id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "id")
    private User user;

    @OneToMany(mappedBy = "mentor")
    private Set<Student> students;
}
