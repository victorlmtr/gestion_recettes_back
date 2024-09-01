package com.gestionrecettes.back.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gestionrecettes.back.model.entity.DurationConverter;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.time.Duration;
import java.util.Collection;
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
    @Convert(converter = DurationConverter.class) // Add this line to use the converter
    private Duration dureeEtape;

    @Column(name = "instructions_etape", nullable = false, length = 2000)
    private String instructionsEtape;

    @Column(name = "image_etape")
    private byte[] imageEtape;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_recette", nullable = false)
    @JsonBackReference
    private Recette recette;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type_etape")
    @JsonManagedReference
    private TypeEtape idTypeEtape;

    @OneToMany(mappedBy = "id.idEtape")
    private Set<IngredientRecette> ingredientRecettes = new LinkedHashSet<>();
}
