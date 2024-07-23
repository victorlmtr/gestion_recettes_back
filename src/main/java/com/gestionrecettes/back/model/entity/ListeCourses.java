package com.gestionrecettes.back.model.entity;

import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "liste_courses")
public class ListeCourses {
    @Id
    @Column(name = "id_liste_courses", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur idUtilisateur;

    @ManyToMany
    @JoinTable(name = "cataloguer",
            joinColumns = @JoinColumn(name = "id_liste_courses"),
            inverseJoinColumns = @JoinColumn(name = "id_non_consommable"))
    private Set<NonConsommable> nonConsommables = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "composer",
            joinColumns = @JoinColumn(name = "id_liste_courses"),
            inverseJoinColumns = @JoinColumn(name = "id_ingredient"))
    private Set<Ingredient> ingredients = new LinkedHashSet<>();

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<NonConsommable> getNonConsommables() {
        return nonConsommables;
    }

    public void setNonConsommables(Set<NonConsommable> nonConsommables) {
        this.nonConsommables = nonConsommables;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

}