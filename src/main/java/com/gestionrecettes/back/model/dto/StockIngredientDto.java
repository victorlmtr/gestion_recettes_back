package com.gestionrecettes.back.model.dto;

import lombok.Value;
import java.io.Serializable;

/**
 * DTO for {@link com.gestionrecettes.back.model.entity.StockIngredient}
 */
@Value
public class StockIngredientDto implements Serializable {
    IngredientDto idIngredient;
    UtilisateurDto idUtilisateur;
}
