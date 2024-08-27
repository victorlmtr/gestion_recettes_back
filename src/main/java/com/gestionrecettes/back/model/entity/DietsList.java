package com.gestionrecettes.back.model.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "choix_categories")
public class DietsList {
    @EmbeddedId
    private DietsListId id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_utilisateur", nullable = false, insertable = false, updatable = false)
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_regime_recette", nullable = false, insertable = false, updatable = false)
    private RegimeRecette regimeRecette;
}