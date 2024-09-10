package xyz.victorl.scrontchback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.victorl.scrontchback.model.entity.Favoris;
import xyz.victorl.scrontchback.model.entity.FavorisId;

@Repository
public interface FavorisRepository extends JpaRepository<Favoris, FavorisId> {
}