package com.gestionrecettes.back.model.entity;

import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.Objects;
import java.time.LocalDate;

@Entity
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

    public CommentaireId getId() {
        return id;
    }

    public void setId(CommentaireId id) {
        this.id = id;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Recette getIdRecette() {
        return idRecette;
    }

    public void setIdRecette(Recette idRecette) {
        this.idRecette = idRecette;
    }

    public Double getNoteAvis() {
        return noteAvis;
    }

    public void setNoteAvis(Double noteAvis) {
        this.noteAvis = noteAvis;
    }

    public String getCommentaireAvis() {
        return commentaireAvis;
    }

    public void setCommentaireAvis(String commentaireAvis) {
        this.commentaireAvis = commentaireAvis;
    }

    public LocalDate getDateCommentaire() {
        return dateCommentaire;
    }

    public void setDateCommentaire(LocalDate dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }

}