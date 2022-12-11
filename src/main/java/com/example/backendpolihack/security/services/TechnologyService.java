package com.example.backendpolihack.security.services;

import com.example.backendpolihack.models.Technology;
import com.example.backendpolihack.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TechnologyService implements ITechnologyService {
    @Autowired
    private TechnologyRepository technologyRepository;

    @Override
    public List<Technology> getAll() {
        return technologyRepository.findAll();
    }

}
