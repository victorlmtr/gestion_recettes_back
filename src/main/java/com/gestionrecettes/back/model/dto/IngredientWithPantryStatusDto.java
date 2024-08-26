package com.gestionrecettes.back.model.dto;

import lombok.Data;

@Data

public class IngredientWithPantryStatusDto {
    private IngredientDto ingredient;
    private boolean inPantry;

    public IngredientWithPantryStatusDto(IngredientDto ingredient, boolean inPantry) {
        this.ingredient = ingredient;
        this.inPantry = inPantry;
    }
}