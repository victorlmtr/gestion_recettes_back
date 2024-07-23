package com.gestionrecettes.back.model.entity;

import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @Column(name = "id_ingredient", nullable = false)
    private Integer id;

    @Column(name = "lib_ingredient", nullable = false, length = 100)
    private String libIngredient;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_categorie_ingredient", nullable = false)
    private CategorieIngredient idCategorieIngredient;

    @ManyToMany
    @JoinTable(name = "composer",
            joinColumns = @JoinColumn(name = "id_ingredient"),
            inverseJoinColumns = @JoinColumn(name = "id_liste_courses"))
    private Set<ListeCourses> listeCourses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idIngredient")
    private Set<IngredientRecette> ingredientRecettes = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "stock_ingredients",
            joinColumns = @JoinColumn(name = "id_ingredient"),
            inverseJoinColumns = @JoinColumn(name = "id_utilisateur"))
    private Set<Utilisateur> utilisateurs = new LinkedHashSet<>();

    public Set<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public Set<IngredientRecette> getIngredientRecettes() {
        return ingredientRecettes;
    }

    public void setIngredientRecettes(Set<IngredientRecette> ingredientRecettes) {
        this.ingredientRecettes = ingredientRecettes;
    }

    public Set<ListeCourses> getListeCourses() {
        return listeCourses;
    }

    public void setListeCourses(Set<ListeCourses> listeCourses) {
        this.listeCourses = listeCourses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibIngredient() {
        return libIngredient;
    }

    public void setLibIngredient(String libIngredient) {
        this.libIngredient = libIngredient;
    }

    public CategorieIngredient getIdCategorieIngredient() {
        return idCategorieIngredient;
    }

    public void setIdCategorieIngredient(CategorieIngredient idCategorieIngredient) {
        this.idCategorieIngredient = idCategorieIngredient;
    }

}