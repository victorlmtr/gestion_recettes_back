package com.gestionrecettes.back.model.dto;

import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.gestionrecettes.back.model.entity.CategorieIngredient}
 */
@Value
public class CategorieIngredientDto implements Serializable {
    Integer id;
    String libCategorieIngredient;
    byte[] iconeCategorie;
    Set<IngredientDto> ingredients;
}