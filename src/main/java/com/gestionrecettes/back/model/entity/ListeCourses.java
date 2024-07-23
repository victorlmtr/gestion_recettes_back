package com.gestionrecettes.back.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
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

}