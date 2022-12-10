package com.example.backendpolihack.repository;

import com.example.backendpolihack.models.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
    Mentor findByUserId(long userId);
}
