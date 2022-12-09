package com.example.backendpolihack.controller;

import com.example.backendpolihack.optaplanner.FoodPlanificationSolution;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.optaplanner.core.api.solver.SolverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class FoodSolutionController {

    private SolverManager<FoodPlanificationSolution, Long> solverManager;

    public FoodSolutionController(SolverManager<FoodPlanificationSolution, Long> solverManager) {

        // When Spring will start, the bean will be injected here and become
        // available in this class
        this.solverManager = solverManager;

    }

    @GetMapping("/solve")
    public FoodPlanificationSolution solve() {
//        UUID problemId = UUID.randomUUID();
//        // Submit the problem to start solving
//        SolverJob<FoodPlanificationSolution, UUID> solverJob = solverManager.solve(problemId, problem);
//        TimeTable solution;
//        try {
//            // Wait until the solving ends
//            solution = solverJob.getFinalBestSolution();
//        } catch (InterruptedException | ExecutionException e) {
//            throw new IllegalStateException("Solving failed.", e);
//        }
//        return solution;
    }
}
