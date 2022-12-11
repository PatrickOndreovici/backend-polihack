package com.example.backendpolihack.repository;

import com.example.backendpolihack.models.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
}

