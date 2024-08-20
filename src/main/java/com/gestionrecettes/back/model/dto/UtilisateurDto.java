package com.gestionrecettes.back.model.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.gestionrecettes.back.model.entity.Utilisateur}
 */
@Value
public class UtilisateurDto implements Serializable {
    Integer id;
    String nomUtilisateur;
    String emailUtilisateur;
    String mdpUtilisateur;
    LocalDate dateCreationUtilisateur;
}