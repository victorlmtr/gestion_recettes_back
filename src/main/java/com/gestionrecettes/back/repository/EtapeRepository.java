package com.gestionrecettes.back.repository;

import com.gestionrecettes.back.model.entity.Etape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtapeRepository extends JpaRepository<Etape, Integer> {
}