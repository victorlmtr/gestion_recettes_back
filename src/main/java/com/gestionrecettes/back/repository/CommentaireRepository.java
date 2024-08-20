package com.gestionrecettes.back.repository;

import com.gestionrecettes.back.model.entity.Commentaire;
import com.gestionrecettes.back.model.entity.CommentaireId;
import com.gestionrecettes.back.model.entity.IngredientRecette;
import com.gestionrecettes.back.model.entity.IngredientRecetteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, CommentaireId> {
}