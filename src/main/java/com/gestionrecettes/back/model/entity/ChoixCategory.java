package com.gestionrecettes.back.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.Objects;
@Entity
@Getter
@Setter
@Table(name = "choix_categories")
public class ChoixCategory {
    @EmbeddedId
    private ChoixCategoryId id;

    @MapsId("idUtilisateur")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur idUtilisateur;

    @MapsId("idRegimeRecette")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_regime_recette", nullable = false)
    private RegimeRecette idRegimeRecette;

}