package com.gestionrecettes.back.repository;

import com.gestionrecettes.back.model.entity.CategorieIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieIngredientRepository extends JpaRepository<CategorieIngredient, Integer> {
}
