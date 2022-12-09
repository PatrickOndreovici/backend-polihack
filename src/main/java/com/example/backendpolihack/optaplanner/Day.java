package com.example.backendpolihack.optaplanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@PlanningEntity
public class Day {

    @PlanningVariable(valueRangeProviderRefs = { "recipeRange" })
    Recipe breakfast;

    @PlanningVariable(valueRangeProviderRefs = { "recipeRange" })
    Recipe lunch;

    @PlanningVariable(valueRangeProviderRefs = { "recipeRange" })
    Recipe dinner;
}
