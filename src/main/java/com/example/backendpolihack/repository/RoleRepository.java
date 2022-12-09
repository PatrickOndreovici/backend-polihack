package com.example.backendpolihack.repository;

import com.example.backendpolihack.models.ERole;
import com.example.backendpolihack.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
