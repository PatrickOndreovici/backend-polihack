package com.example.backendpolihack.optaplanner.solver;

import com.example.backendpolihack.optaplanner.models.Day;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;

public class FoodSolutionConstraintProvider implements ConstraintProvider {
    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[]{
                // Hard constraints
                recipeConflict(constraintFactory),
        };

    }

    Constraint recipeConflict(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEachUniquePair(Day.class, Joiners.equal(Day::getBreakfast)).penalize(HardSoftScore.ONE_HARD).asConstraint("Recipe conflict");
    }
}
