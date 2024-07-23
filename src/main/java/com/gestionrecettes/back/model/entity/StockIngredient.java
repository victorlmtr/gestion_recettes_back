package com.gestionrecettes.back.model.entity;

import org.hibernate.Hibernate;
import jakarta.persistence.*;

@Entity
@Table(name = "stock_ingredients")
public class StockIngredient {
    @EmbeddedId
    private StockIngredientId id;

    @MapsId("idIngredient")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_ingredient", nullable = false)
    private Ingredient idIngredient;

    @MapsId("idUtilisateur")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur idUtilisateur;

    public StockIngredientId getId() {
        return id;
    }

    public void setId(StockIngredientId id) {
        this.id = id;
    }

    public Ingredient getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Ingredient idIngredient) {
        this.idIngredient = idIngredient;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

}