package com.gestionrecettes.back.model.dto;

import lombok.Value;
import java.io.Serializable;

/**
 * DTO for ingredient status in a recipe, whether the ingredient is in the user's pantry
 */
@Value
public class IngredientRecetteStatusDto implements Serializable {
    IngredientRecetteDto ingredientRecette;
    Boolean isInPantry;

    public IngredientRecetteStatusDto(IngredientRecetteDto ingredientRecette, Boolean isInPantry) {
        this.ingredientRecette = ingredientRecette;
        this.isInPantry = isInPantry;
    }
}
