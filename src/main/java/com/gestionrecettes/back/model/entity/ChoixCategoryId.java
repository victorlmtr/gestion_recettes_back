package com.gestionrecettes.back.model.entity;

import org.hibernate.Hibernate;

import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.Objects;

@Embeddable
public class ChoixCategoryId implements java.io.Serializable {
    private static final long serialVersionUID = 2072212891791070851L;
    @Column(name = "id_utilisateur", nullable = false)
    private Integer idUtilisateur;

    @Column(name = "id_regime_recette", nullable = false)
    private Integer idRegimeRecette;

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Integer getIdRegimeRecette() {
        return idRegimeRecette;
    }

    public void setIdRegimeRecette(Integer idRegimeRecette) {
        this.idRegimeRecette = idRegimeRecette;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ChoixCategoryId entity = (ChoixCategoryId) o;
        return Objects.equals(this.idRegimeRecette, entity.idRegimeRecette) &&
                Objects.equals(this.idUtilisateur, entity.idUtilisateur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRegimeRecette, idUtilisateur);
    }

}