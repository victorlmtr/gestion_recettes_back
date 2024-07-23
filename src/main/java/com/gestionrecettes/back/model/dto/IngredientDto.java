package com.gestionrecettes.back.model.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.gestionrecettes.back.model.entity.Ingredient}
 */
@Value
public class IngredientDto implements Serializable {
    Integer id;
    String libIngredient;
    CategorieIngredientDto categorieIngredient;
}