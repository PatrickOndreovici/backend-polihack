package com.example.backendpolihack.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    private Long id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "id")
    private User user;

    @ManyToMany(mappedBy = "students", cascade = { CascadeType.ALL })
    private Set<Technology> technologies = new HashSet<Technology>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mentor")
    private Mentor mentor;

    @OneToMany(mappedBy = "student")
    private Set<Task> tasks;
}
