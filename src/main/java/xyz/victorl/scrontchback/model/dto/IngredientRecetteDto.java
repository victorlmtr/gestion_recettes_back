package xyz.victorl.scrontchback.model.dto;

import lombok.Value;
import xyz.victorl.scrontchback.model.entity.IngredientRecette;

import java.io.Serializable;

/**
 * DTO for {@link IngredientRecette}
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