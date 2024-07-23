package com.gestionrecettes.back.model.entity;

import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.Objects;

@Embeddable
public class FavorisId implements java.io.Serializable {
    private static final long serialVersionUID = 7461710551976930544L;
    @Column(name = "id_recette", nullable = false)
    private Integer idRecette;

    @Column(name = "id_utilisateur", nullable = false)
    private Integer idUtilisateur;

    public Integer getIdRecette() {
        return idRecette;
    }

    public void setIdRecette(Integer idRecette) {
        this.idRecette = idRecette;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FavorisId entity = (FavorisId) o;
        return Objects.equals(this.idRecette, entity.idRecette) &&
                Objects.equals(this.idUtilisateur, entity.idUtilisateur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecette, idUtilisateur);
    }

}