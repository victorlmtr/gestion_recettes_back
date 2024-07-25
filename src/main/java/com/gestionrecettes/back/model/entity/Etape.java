package com.gestionrecettes.back.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.time.OffsetTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "etape")
public class Etape {
    @Id
    @Column(name = "id_etape", nullable = false)
    private Integer id;

    @Column(name = "duree_etape", nullable = false)
    private OffsetTime dureeEtape;

    @Column(name = "instructions_etape", nullable = false, length = 2000)
    private String instructionsEtape;

    @Column(name = "image_etape")
    private byte[] imageEtape;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_recette", nullable = false)
    private Recette idRecette;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_etape")
    private TypeEtape idTypeEtape;

    @OneToMany(mappedBy = "id.idEtape")
    private Set<IngredientRecette> ingredientRecettes = new LinkedHashSet<>();

}