package xyz.victorl.scrontchback.repository;

import xyz.victorl.scrontchback.model.entity.Commentaire;
import xyz.victorl.scrontchback.model.entity.CommentaireId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, CommentaireId> {
    List<Commentaire> findByRecetteId(Integer recetteId);
}