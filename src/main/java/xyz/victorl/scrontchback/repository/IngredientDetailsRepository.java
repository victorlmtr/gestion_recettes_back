package xyz.victorl.scrontchback.repository;

import xyz.victorl.scrontchback.model.entity.IngredientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientDetailsRepository extends JpaRepository<IngredientDetails, Integer> {
}