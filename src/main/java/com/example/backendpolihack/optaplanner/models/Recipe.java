package com.example.backendpolihack.optaplanner.models;

import org.optaplanner.core.api.domain.lookup.PlanningId;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Recipe {
    @PlanningId
    private Long id;
    String name;
    int happiness;
    Double cost;
}
