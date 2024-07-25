package com.gestionrecettes.back.model.dto;

import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.gestionrecettes.back.model.entity.IngredientRecette}
 */
@Value
public class IngredientRecetteDto implements Serializable {
    IngredientDto idIngredient;
    EtapeDto idEtape;
    UniteMesureDto idUniteMesure;
    IngredientDetailsDto idIngredientDetails;
    Boolean estFacultatif;
    Double quantite;
}