package xyz.victorl.scrontchback.model.dto;

import lombok.Value;
import xyz.victorl.scrontchback.model.entity.CategorieIngredient;

import java.io.Serializable;

/**
 * DTO for {@link CategorieIngredient}
 */
@Value
public class CategorieIngredientDto implements Serializable {
    Integer id;
    String libCategorieIngredient;
    byte[] iconeCategorie;
}