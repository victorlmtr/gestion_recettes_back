package com.gestionrecettes.back.repository;

import com.gestionrecettes.back.model.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestionrecettes.back.model.dto.IngredientDto;
import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByNomUtilisateur(String nomUtilisateur);
}
