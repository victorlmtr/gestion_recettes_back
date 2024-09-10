package xyz.victorl.scrontchback.model.dto;

import lombok.Value;
import xyz.victorl.scrontchback.model.entity.StockIngredient;

import java.io.Serializable;

/**
 * DTO for {@link StockIngredient}
 */
@Value
public class StockIngredientDto implements Serializable {
    IngredientDto idIngredient;
    UtilisateurDto idUtilisateur;
}
