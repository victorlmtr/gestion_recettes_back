package xyz.victorl.scrontchback.model.dto;

import lombok.Value;
import xyz.victorl.scrontchback.model.entity.Favoris;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Favoris}
 */
@Value
public class FavorisDto implements Serializable {
    RecetteDto idRecette;
    UtilisateurDto idUtilisateur;
    LocalDate dateFavori;
}
