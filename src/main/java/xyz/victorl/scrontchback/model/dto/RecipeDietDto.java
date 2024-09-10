package xyz.victorl.scrontchback.model.dto;

import lombok.Value;
import xyz.victorl.scrontchback.model.entity.RecipeDiet;

import java.io.Serializable;

/**
 * DTO for {@link RecipeDiet}
 */
@Value
public class RecipeDietDto implements Serializable {
    RegimeRecetteDto idRegimeRecette;
    RecetteDto idRecette;
}

