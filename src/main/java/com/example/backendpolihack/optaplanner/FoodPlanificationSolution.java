package com.example.backendpolihack.optaplanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@PlanningSolution
public class FoodPlanificationSolution {

    double budget;

    @ValueRangeProvider(id = "recipeRange")
    @ProblemFactCollectionProperty
    List<Recipe> recipeList;

    @PlanningEntityCollectionProperty
    List<Day> days;

    @PlanningScore
    private HardSoftScore score;
}
