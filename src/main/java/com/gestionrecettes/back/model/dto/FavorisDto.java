package com.gestionrecettes.back.model.dto;

import lombok.Value;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.gestionrecettes.back.model.entity.Favoris}
 */
@Value
public class FavorisDto implements Serializable {
    RecetteDto idRecette;
    UtilisateurDto idUtilisateur;
    LocalDate dateFavori;
}
