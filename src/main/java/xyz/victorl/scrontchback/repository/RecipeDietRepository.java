package xyz.victorl.scrontchback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.victorl.scrontchback.model.entity.RecipeDiet;
import xyz.victorl.scrontchback.model.entity.RecipeDietId;
import xyz.victorl.scrontchback.model.entity.RegimeRecette;

import java.util.List;

@Repository
public interface RecipeDietRepository extends JpaRepository<RecipeDiet, RecipeDietId> {

    List<RecipeDiet> findByRegimeRecetteIn(List<RegimeRecette> regimeRecettes);
}