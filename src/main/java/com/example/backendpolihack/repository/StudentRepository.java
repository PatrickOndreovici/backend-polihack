package com.example.backendpolihack.repository;

import com.example.backendpolihack.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
