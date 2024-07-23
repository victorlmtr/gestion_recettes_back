package com.gestionrecettes.back.repository;

import com.gestionrecettes.back.model.entity.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, Integer> {
}
