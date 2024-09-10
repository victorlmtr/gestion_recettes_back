package xyz.victorl.scrontchback.model.dto;

import lombok.Value;
import xyz.victorl.scrontchback.model.entity.Ingredient;

import java.io.Serializable;

/**
 * DTO for {@link Ingredient}
 */
@Value
public class IngredientDto implements Serializable {
    Integer id;
    String libIngredient;
    CategorieIngredientDto categorieIngredient;
}