package com.gestionrecettes.back.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.Objects;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "commentaires")
public class Commentaire {
    @EmbeddedId
    private CommentaireId id;

    @MapsId("idUtilisateur")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur idUtilisateur;

    @MapsId("idRecette")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_recette", nullable = false)
    private Recette idRecette;

    @Column(name = "note_avis", nullable = false)
    private Double noteAvis;

    @Column(name = "commentaire_avis", length = 2000)
    private String commentaireAvis;

    @Column(name = "date_commentaire")
    private LocalDate dateCommentaire;
}