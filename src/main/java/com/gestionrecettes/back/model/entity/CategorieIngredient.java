package com.gestionrecettes.back.model.entity;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
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

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibCategorieIngredient() {
        return libCategorieIngredient;
    }

    public void setLibCategorieIngredient(String libCategorieIngredient) {
        this.libCategorieIngredient = libCategorieIngredient;
    }

    public byte[] getIconeCategorie() {
        return iconeCategorie;
    }

    public void setIconeCategorie(byte[] iconeCategorie) {
        this.iconeCategorie = iconeCategorie;
    }

}