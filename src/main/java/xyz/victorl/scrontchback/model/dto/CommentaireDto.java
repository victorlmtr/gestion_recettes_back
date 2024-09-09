package xyz.victorl.scrontchback.model.dto;

import lombok.Value;
import xyz.victorl.scrontchback.model.entity.Commentaire;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Commentaire}
 */
@Value
public class CommentaireDto implements Serializable {
    UtilisateurDto idUtilisateur;
    RecetteDto idRecette;
    Double noteAvis;
    String commentaireAvis;
    LocalDate dateCommentaire;
}
