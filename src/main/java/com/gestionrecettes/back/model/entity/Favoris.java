package com.gestionrecettes.back.model.entity;

import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "favoris")
public class Favoris {
    @EmbeddedId
    private FavorisId id;

    @MapsId("idRecette")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_recette", nullable = false)
    private Recette idRecette;

    @MapsId("idUtilisateur")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur idUtilisateur;

    @Column(name = "date_favori", nullable = false)
    private LocalDate dateFavori;

    public FavorisId getId() {
        return id;
    }

    public void setId(FavorisId id) {
        this.id = id;
    }

    public Recette getIdRecette() {
        return idRecette;
    }

    public void setIdRecette(Recette idRecette) {
        this.idRecette = idRecette;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public LocalDate getDateFavori() {
        return dateFavori;
    }

    public void setDateFavori(LocalDate dateFavori) {
        this.dateFavori = dateFavori;
    }

}