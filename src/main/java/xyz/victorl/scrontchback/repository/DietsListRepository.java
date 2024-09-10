package xyz.victorl.scrontchback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import xyz.victorl.scrontchback.model.entity.DietsList;
import xyz.victorl.scrontchback.model.entity.DietsListId;
import xyz.victorl.scrontchback.model.entity.RegimeRecette;

import java.util.List;

@Repository
public interface DietsListRepository extends JpaRepository<DietsList, DietsListId> {

    @Query("SELECT d.regimeRecette FROM DietsList d WHERE d.utilisateur.id = :userId")
    List<RegimeRecette> findByUtilisateur_Id(@Param("userId") Integer userId);
}