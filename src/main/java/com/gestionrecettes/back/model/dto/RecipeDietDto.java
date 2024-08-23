package com.gestionrecettes.back.model.dto;

import lombok.Value;
import java.io.Serializable;

/**
 * DTO for {@link com.gestionrecettes.back.model.entity.RecipeDiet}
 */
@Value
public class RecipeDietDto implements Serializable {
    RegimeRecetteDto idRegimeRecette;
    RecetteDto idRecette;
}

