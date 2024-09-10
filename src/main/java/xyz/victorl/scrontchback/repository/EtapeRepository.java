package xyz.victorl.scrontchback.repository;

import xyz.victorl.scrontchback.model.entity.Etape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtapeRepository extends JpaRepository<Etape, Integer> {
}