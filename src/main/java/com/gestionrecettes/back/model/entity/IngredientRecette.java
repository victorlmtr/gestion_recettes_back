package com.gestionrecettes.back.model.entity;

import org.hibernate.Hibernate;
import jakarta.persistence.*;

@Entity
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

    public IngredientRecetteId getId() {
        return id;
    }

    public void setId(IngredientRecetteId id) {
        this.id = id;
    }

    public Ingredient getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Ingredient idIngredient) {
        this.idIngredient = idIngredient;
    }

    public Etape getIdEtape() {
        return idEtape;
    }

    public void setIdEtape(Etape idEtape) {
        this.idEtape = idEtape;
    }

    public UniteMesure getIdUniteMesure() {
        return idUniteMesure;
    }

    public void setIdUniteMesure(UniteMesure idUniteMesure) {
        this.idUniteMesure = idUniteMesure;
    }

    public IngredientDetails getIdIngredientDetails() {
        return idIngredientDetails;
    }

    public void setIdIngredientDetails(IngredientDetails idIngredientDetails) {
        this.idIngredientDetails = idIngredientDetails;
    }

    public Boolean getEstFacultatif() {
        return estFacultatif;
    }

    public void setEstFacultatif(Boolean estFacultatif) {
        this.estFacultatif = estFacultatif;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

}