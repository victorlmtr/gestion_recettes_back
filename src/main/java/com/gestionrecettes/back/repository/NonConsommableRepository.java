package com.gestionrecettes.back.repository;

import com.gestionrecettes.back.model.entity.NonConsommable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NonConsommableRepository extends JpaRepository<NonConsommable, Integer> {
}

