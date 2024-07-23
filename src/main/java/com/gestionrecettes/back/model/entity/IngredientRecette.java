package com.gestionrecettes.back.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "ingredient_recette")
public class IngredientRecette {
    @EmbeddedId
    private IngredientRecetteId id;

    @MapsId("idIngredient")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_ingredient", nullable = false)
    private Ingredient idIngredient;

    @MapsId("idEtape")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_etape", nullable = false)
    private Etape idEtape;

    @MapsId("idUniteMesure")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_unite_mesure", nullable = false)
    private UniteMesure idUniteMesure;

    @MapsId("idIngredientDetails")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_ingredient_details", nullable = false)
    private IngredientDetails idIngredientDetails;

    @Column(name = "est_facultatif", nullable = false)
    private Boolean estFacultatif = false;

    @Column(name = "quantite", nullable = false)
    private Double quantite;

}