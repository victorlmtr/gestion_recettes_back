package com.gestionrecettes.back.repository;

import com.gestionrecettes.back.model.entity.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetteRepository extends JpaRepository<Recette, Integer> {
}
