package com.example.backendpolihack.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "technologies")
public class Technology {
    @Id
    private Long id;
    private String name;
    private String description;
    private String image;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "technology_student", joinColumns = { @JoinColumn(name = "technology_id")
    }, inverseJoinColumns = { @JoinColumn(name = "student_id") })
    private Set<Student> students = new HashSet<Student>();

}
