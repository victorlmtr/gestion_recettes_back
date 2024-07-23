package com.gestionrecettes.back.model.entity;

import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "unite_mesure")
public class UniteMesure {
    @Id
    @Column(name = "id_unite_mesure", nullable = false)
    private Integer id;

    @Column(name = "lib_unite_mesure", nullable = false, length = 100)
    private String libUniteMesure;

    @OneToMany(mappedBy = "idUniteMesure")
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

    public String getLibUniteMesure() {
        return libUniteMesure;
    }

    public void setLibUniteMesure(String libUniteMesure) {
        this.libUniteMesure = libUniteMesure;
    }

}