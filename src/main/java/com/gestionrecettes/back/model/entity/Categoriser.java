package com.gestionrecettes.back.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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

}