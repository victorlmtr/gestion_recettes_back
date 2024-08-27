package com.gestionrecettes.back.repository;

import com.gestionrecettes.back.model.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DietsListRepository extends JpaRepository<DietsList, DietsListId> {

    @Query("SELECT d.regimeRecette FROM DietsList d WHERE d.utilisateur.id = :userId")
    List<RegimeRecette> findByUtilisateur_Id(@Param("userId") Integer userId);
}