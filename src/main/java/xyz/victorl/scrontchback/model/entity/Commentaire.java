package xyz.victorl.scrontchback.model.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "commentaires")
public class Commentaire {
    @EmbeddedId
    private CommentaireId id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_utilisateur", nullable = false, insertable = false, updatable = false)
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_recette", nullable = false, insertable = false, updatable = false)
    private Recette recette;

    @Column(name = "note_avis", nullable = false)
    private Double noteAvis;

    @Column(name = "commentaire_avis", length = 2000)
    private String commentaireAvis;

    @Column(name = "date_commentaire")
    private LocalDate dateCommentaire;
}