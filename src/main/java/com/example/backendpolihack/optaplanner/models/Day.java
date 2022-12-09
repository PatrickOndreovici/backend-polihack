package com.example.backendpolihack.optaplanner.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@PlanningEntity
public class Day {

    @PlanningId
    private Long id;

    @PlanningVariable(valueRangeProviderRefs = { "recipeRange" })
    Recipe breakfast;
}
