package com.gestionrecettes.back.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categoriser")
public class Categoriser {
    @EmbeddedId
    private CategoriserId id;

    @MapsId("idRegimeRecette")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_regime_recette", nullable = false)
    private RegimeRecette idRegimeRecette;

    @MapsId("idRecette")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_recette", nullable = false)
    private Recette idRecette;

    public CategoriserId getId() {
        return id;
    }

    public void setId(CategoriserId id) {
        this.id = id;
    }

    public RegimeRecette getIdRegimeRecette() {
        return idRegimeRecette;
    }

    public void setIdRegimeRecette(RegimeRecette idRegimeRecette) {
        this.idRegimeRecette = idRegimeRecette;
    }

    public Recette getIdRecette() {
        return idRecette;
    }

    public void setIdRecette(Recette idRecette) {
        this.idRecette = idRecette;
    }

}