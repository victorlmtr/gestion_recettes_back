package com.gestionrecettes.back.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingredient", nullable = false)
    private Integer id;

    @Column(name = "lib_ingredient", nullable = false, length = 100)
    private String libIngredient;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_categorie_ingredient", nullable = false)
    @JsonBackReference
    private CategorieIngredient categorieIngredient;

    @ManyToMany
    @JoinTable(name = "composer",
            joinColumns = @JoinColumn(name = "id_ingredient"),
            inverseJoinColumns = @JoinColumn(name = "id_liste_courses"))
    private Set<ListeCourses> listeCourses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "id.idIngredient")
    private Set<IngredientRecette> ingredientRecettes = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "stock_ingredients",
            joinColumns = @JoinColumn(name = "id_ingredient"),
            inverseJoinColumns = @JoinColumn(name = "id_utilisateur"))
    private Set<Utilisateur> utilisateurs = new LinkedHashSet<>();

}