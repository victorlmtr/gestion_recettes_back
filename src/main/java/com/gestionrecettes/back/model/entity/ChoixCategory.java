package com.gestionrecettes.back.model.entity;

import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "choix_categories")
public class ChoixCategory {
    @EmbeddedId
    private ChoixCategoryId id;

    @MapsId("idUtilisateur")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur idUtilisateur;

    @MapsId("idRegimeRecette")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_regime_recette", nullable = false)
    private RegimeRecette idRegimeRecette;

    public ChoixCategoryId getId() {
        return id;
    }

    public void setId(ChoixCategoryId id) {
        this.id = id;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public RegimeRecette getIdRegimeRecette() {
        return idRegimeRecette;
    }

    public void setIdRegimeRecette(RegimeRecette idRegimeRecette) {
        this.idRegimeRecette = idRegimeRecette;
    }

}