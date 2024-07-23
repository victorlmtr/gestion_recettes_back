package com.gestionrecettes.back.repository;

import com.gestionrecettes.back.model.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByNomUtilisateur(String nomUtilisateur);
}
