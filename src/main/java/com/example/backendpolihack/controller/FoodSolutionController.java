package com.example.backendpolihack.controller;

import com.example.backendpolihack.optaplanner.models.FoodPlanificationSolution;
import org.optaplanner.core.api.solver.SolverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class FoodSolutionController {

//    Autowire the solverManager with the FoodPlanificationSolution
    @Autowired
    private SolverManager<FoodPlanificationSolution, Long> solverManager;
    
    @GetMapping("/solve")
    public FoodPlanificationSolution solve() {
        UUID problemId = UUID.randomUUID();

        return null;
    }
}
