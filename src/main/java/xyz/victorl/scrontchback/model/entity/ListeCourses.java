package xyz.victorl.scrontchback.model.entity;

import lombok.Getter;
import lombok.Setter;
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

    @OneToMany(mappedBy = "idListeCourses", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<IngredientsList> ingredients = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idListeCourses", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<NonFoodList> nonFoodItems = new LinkedHashSet<>();

}