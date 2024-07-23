package com.gestionrecettes.back.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "categorie_ingredient")
public class CategorieIngredient {
    @Id
    @Column(name = "id_categorie_ingredient", nullable = false)
    private Integer id;

    @Column(name = "lib_categorie_ingredient", nullable = false, length = 100)
    private String libCategorieIngredient;

    @Column(name = "icone_categorie", nullable = false)
    private byte[] iconeCategorie;

    @OneToMany(mappedBy = "idCategorieIngredient")
    private Set<Ingredient> ingredients = new LinkedHashSet<>();


}