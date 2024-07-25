package com.gestionrecettes.back.model.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.gestionrecettes.back.model.entity.IngredientDetails}
 */
@Value
public class IngredientDetailsDto implements Serializable {
    Integer id;
    String libIngredientDetails;
}