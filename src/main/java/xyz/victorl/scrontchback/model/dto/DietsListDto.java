package xyz.victorl.scrontchback.model.dto;

import lombok.Value;
import xyz.victorl.scrontchback.model.entity.Commentaire;

import java.io.Serializable;

/**
 * DTO for {@link Commentaire}
 */
@Value
public class DietsListDto implements Serializable {
    UtilisateurDto idUtilisateur;
    RegimeRecetteDto idRegimeRecette;
}