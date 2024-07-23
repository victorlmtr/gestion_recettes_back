package com.gestionrecettes.back.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "recette")
public class Recette {
    @Id
    @Column(name = "id_recette", nullable = false)
    private Integer id;

    @Column(name = "lib_recette", nullable = false, length = 100)
    private String libRecette;

    @Column(name = "description_recette", nullable = false, length = 2000)
    private String descriptionRecette;

    @Column(name = "difficulte_recette", nullable = false)
    private Integer difficulteRecette;

    @Column(name = "nombre_portion", nullable = false)
    private Integer nombrePortion;

    @Column(name = "remarque_recette", nullable = false, length = 2000)
    private String remarqueRecette;

    @Column(name = "date_publication_recette", nullable = false)
    private LocalDate datePublicationRecette;

    @Column(name = "image_recette")
    private byte[] imageRecette;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_pays", nullable = false)
    private Pays idPays;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_type_recette", nullable = false)
    private TypeRecette idTypeRecette;

    @ManyToMany
    @JoinTable(name = "categoriser",
            joinColumns = @JoinColumn(name = "id_recette"),
            inverseJoinColumns = @JoinColumn(name = "id_regime_recette"))
    private Set<RegimeRecette> regimeRecettes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idRecette")
    private Set<Commentaire> commentaires = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idRecette")
    private Set<Etape> etapes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idRecette")
    private Set<Favoris> favorites = new LinkedHashSet<>();


}