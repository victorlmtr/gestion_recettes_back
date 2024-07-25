package com.gestionrecettes.back.repository;

import com.gestionrecettes.back.model.entity.IngredientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientDetailsRepository extends JpaRepository<IngredientDetails, Integer> {
}