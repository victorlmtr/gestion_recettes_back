package com.gestionrecettes.back.model.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "ingredient_recette")
public class IngredientRecette {
    @EmbeddedId
    private IngredientRecetteId id;

    @Column(name = "est_facultatif", nullable = false)
    private Boolean estFacultatif = false;

    @Column(name = "quantite", nullable = false)
    private Double quantite;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_ingredient", nullable = false, insertable = false, updatable = false)
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_etape", nullable = false, insertable = false, updatable = false)
    private Etape etape;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_ingredient_details", nullable = false, insertable = false, updatable = false)
    private IngredientDetails ingredientDetails;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_unite_mesure", nullable = false, insertable = false, updatable = false)
    private UniteMesure uniteMesure;

}