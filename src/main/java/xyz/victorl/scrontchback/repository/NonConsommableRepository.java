package xyz.victorl.scrontchback.repository;

import xyz.victorl.scrontchback.model.entity.NonConsommable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NonConsommableRepository extends JpaRepository<NonConsommable, Integer> {
}

