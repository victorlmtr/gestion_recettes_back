package xyz.victorl.scrontchback.model.dto;

import lombok.Data;

@Data

public class IngredientWithPantryStatusDto {
    private IngredientDto ingredient;
    private IngredientDetailsDto ingredientDetails;
    private boolean inPantry;

    public IngredientWithPantryStatusDto(IngredientDto ingredient, IngredientDetailsDto ingredientDetails, boolean inPantry) {
        this.ingredient = ingredient;
        this.ingredientDetails = ingredientDetails;
        this.inPantry = inPantry;
    }
}