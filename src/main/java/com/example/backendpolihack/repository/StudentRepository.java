package com.example.backendpolihack.repository;

import com.example.backendpolihack.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUserId(Long userId);
}
