package com.gestionrecettes.back.repository;

import com.gestionrecettes.back.model.entity.RegimeRecette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegimeRecetteRepository extends JpaRepository<RegimeRecette, Integer> {
}

