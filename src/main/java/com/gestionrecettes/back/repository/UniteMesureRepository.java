package com.gestionrecettes.back.repository;

import com.gestionrecettes.back.model.entity.UniteMesure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniteMesureRepository extends JpaRepository<UniteMesure, Integer> {
}
