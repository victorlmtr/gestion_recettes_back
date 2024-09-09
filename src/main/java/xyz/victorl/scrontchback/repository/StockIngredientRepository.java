package xyz.victorl.scrontchback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.victorl.scrontchback.model.entity.StockIngredient;
import xyz.victorl.scrontchback.model.entity.StockIngredientId;

import java.util.List;

@Repository
public interface StockIngredientRepository extends JpaRepository<StockIngredient, StockIngredientId> {
    List<StockIngredient> findByUtilisateurId(Integer idUtilisateur);
}