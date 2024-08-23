package com.gestionrecettes.back.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "categoriser")
public class RecipeDiet {
    @EmbeddedId
    private RecipeDietId id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_regime_recette", nullable = false, insertable = false, updatable = false)
    private RegimeRecette regimeRecette;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_recette", nullable = false, insertable = false, updatable = false)
    private Recette recette;

}