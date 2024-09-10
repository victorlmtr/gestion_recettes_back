package xyz.victorl.scrontchback.repository;

import xyz.victorl.scrontchback.model.entity.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecetteRepository extends JpaRepository<Recette, Integer> {

    List<Recette> findByIdPays_Id(Integer idPays);

    @Query("SELECT r FROM Recette r WHERE r.idPays.idContinent.id = :idContinent")
    List<Recette> findByContinentId(@Param("idContinent") Integer idContinent);

    List<Recette> findByIdTypeRecette_Id(Integer idTypeRecette);

    @Query("SELECT r FROM Recette r JOIN r.regimeRecettes regime WHERE regime.id = :idRegimeRecette")
    List<Recette> findByRegimeRecettes(@Param("idRegimeRecette") Integer idRegimeRecette);

    @Query("SELECT r FROM Recette r WHERE " +
            "(:idTypeRecette IS NULL OR r.idTypeRecette.id = :idTypeRecette) AND " +
            "(:idRegimeRecette IS NULL OR :idRegimeRecette MEMBER OF r.regimeRecettes) AND " +
            "(:difficulteRecette IS NULL OR r.difficulteRecette = :difficulteRecette) AND " +
            "(:idPays IS NULL OR r.idPays.id = :idPays) AND " +
            "(:idContinent IS NULL OR r.idPays.idContinent.id = :idContinent)")
    List<Recette> findByFilters(
            @Param("idTypeRecette") Integer idTypeRecette,
            @Param("idRegimeRecette") Integer idRegimeRecette,
            @Param("difficulteRecette") Integer difficulteRecette,
            @Param("idPays") Integer idPays,
            @Param("idContinent") Integer idContinent);
}
