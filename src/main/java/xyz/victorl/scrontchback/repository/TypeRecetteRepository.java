package xyz.victorl.scrontchback.repository;


import xyz.victorl.scrontchback.model.entity.TypeRecette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRecetteRepository extends JpaRepository<TypeRecette, Integer> {
}
