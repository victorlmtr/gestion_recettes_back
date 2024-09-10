package xyz.victorl.scrontchback.model.dto;

import lombok.Value;
import xyz.victorl.scrontchback.model.entity.Utilisateur;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Utilisateur}
 */
@Value
public class UtilisateurDto implements Serializable {
    Integer id;
    String nomUtilisateur;
    String emailUtilisateur;
    String mdpUtilisateur;
    LocalDate dateCreationUtilisateur;
}