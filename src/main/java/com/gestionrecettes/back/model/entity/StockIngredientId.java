package com.gestionrecettes.back.model.entity;

import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.Objects;

@Embeddable
public class StockIngredientId implements java.io.Serializable {
    private static final long serialVersionUID = 5736225677277140478L;
    @Column(name = "id_ingredient", nullable = false)
    private Integer idIngredient;

    @Column(name = "id_utilisateur", nullable = false)
    private Integer idUtilisateur;

    public Integer getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Integer idIngredient) {
        this.idIngredient = idIngredient;
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
        StockIngredientId entity = (StockIngredientId) o;
        return Objects.equals(this.idIngredient, entity.idIngredient) &&
                Objects.equals(this.idUtilisateur, entity.idUtilisateur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIngredient, idUtilisateur);
    }

}