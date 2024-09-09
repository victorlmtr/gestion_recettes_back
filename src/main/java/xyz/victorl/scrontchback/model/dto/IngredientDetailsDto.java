package xyz.victorl.scrontchback.model.dto;

import lombok.Value;
import xyz.victorl.scrontchback.model.entity.IngredientDetails;

import java.io.Serializable;

/**
 * DTO for {@link IngredientDetails}
 */
@Value
public class IngredientDetailsDto implements Serializable {
    Integer id;
    String libIngredientDetails;
}