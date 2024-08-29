package com.gestionrecettes.back.repository;

import com.gestionrecettes.back.model.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    List<Ingredient> findByCategorieIngredient_Id(Integer idCategorie);
}
