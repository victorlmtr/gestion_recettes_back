package com.gestionrecettes.back.model.dto;

import lombok.Value;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.gestionrecettes.back.model.entity.Commentaire}
 */
@Value
public class DietsListDto implements Serializable {
    UtilisateurDto idUtilisateur;
    RegimeRecetteDto idRegimeRecette;
}