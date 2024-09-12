package xyz.victorl.scrontchback.model.dto;

import lombok.Data;

@Data

public class IngredientWithPantryStatusDto {
    private IngredientDto ingredient;
    private IngredientRecetteDto ingredientRecette;
    private boolean inPantry;

    public IngredientWithPantryStatusDto(IngredientDto ingredient, IngredientRecetteDto ingredientRecette, boolean inPantry) {
        this.ingredient = ingredient;
        this.ingredientRecette = ingredientRecette;
        this.inPantry = inPantry;
    }
}