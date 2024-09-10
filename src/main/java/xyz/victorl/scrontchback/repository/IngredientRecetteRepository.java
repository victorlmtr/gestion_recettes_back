package xyz.victorl.scrontchback.repository;

import xyz.victorl.scrontchback.model.entity.IngredientRecette;
import xyz.victorl.scrontchback.model.entity.IngredientRecetteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRecetteRepository extends JpaRepository<IngredientRecette, IngredientRecetteId> {

    List<IngredientRecette> findByEtapeId(Integer idEtape);
}
