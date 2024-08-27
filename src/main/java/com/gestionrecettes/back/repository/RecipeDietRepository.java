package com.gestionrecettes.back.repository;

import com.gestionrecettes.back.model.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeDietRepository extends JpaRepository<RecipeDiet, RecipeDietId> {

    List<RecipeDiet> findByRegimeRecetteIn(List<RegimeRecette> regimeRecettes);
}