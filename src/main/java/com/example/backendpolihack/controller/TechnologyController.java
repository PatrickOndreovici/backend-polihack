package com.example.backendpolihack.controller;

import com.example.backendpolihack.models.Technology;
import com.example.backendpolihack.security.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/technologies")
public class TechnologyController {
    @Autowired
    private TechnologyService technologyService;

    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<List<Technology>> getAll() {
        return ResponseEntity.ok(technologyService.getAll());
    }
}
