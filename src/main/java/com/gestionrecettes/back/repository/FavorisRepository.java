package com.gestionrecettes.back.repository;

import com.gestionrecettes.back.model.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavorisRepository extends JpaRepository<Favoris, FavorisId> {
}