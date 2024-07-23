package com.gestionrecettes.back.model.entity;

import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "ingredient_details")
public class IngredientDetails {
    @Id
    @Column(name = "id_ingredient_details", nullable = false)
    private Integer id;

    @Column(name = "lib_ingredient_details", nullable = false, length = 2000)
    private String libIngredientDetails;

    @OneToMany(mappedBy = "idIngredientDetails")
    private Set<IngredientRecette> ingredientRecettes = new LinkedHashSet<>();

    public Set<IngredientRecette> getIngredientRecettes() {
        return ingredientRecettes;
    }

    public void setIngredientRecettes(Set<IngredientRecette> ingredientRecettes) {
        this.ingredientRecettes = ingredientRecettes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibIngredientDetails() {
        return libIngredientDetails;
    }

    public void setLibIngredientDetails(String libIngredientDetails) {
        this.libIngredientDetails = libIngredientDetails;
    }

}