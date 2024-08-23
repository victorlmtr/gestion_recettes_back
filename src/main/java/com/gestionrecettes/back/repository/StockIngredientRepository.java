package com.gestionrecettes.back.repository;

import com.gestionrecettes.back.model.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockIngredientRepository extends JpaRepository<StockIngredient, StockIngredientId> {
    List<StockIngredient> findByUtilisateurId(Integer idUtilisateur);
}