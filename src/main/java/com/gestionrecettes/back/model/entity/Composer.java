package com.gestionrecettes.back.model.entity;

import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "composer")
public class Composer {
    @EmbeddedId
    private ComposerId id;

    @MapsId("idListeCourses")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_liste_courses", nullable = false)
    private ListeCourses idListeCourses;

    @MapsId("idIngredient")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_ingredient", nullable = false)
    private Ingredient idIngredient;

    public ComposerId getId() {
        return id;
    }

    public void setId(ComposerId id) {
        this.id = id;
    }

    public ListeCourses getIdListeCourses() {
        return idListeCourses;
    }

    public void setIdListeCourses(ListeCourses idListeCourses) {
        this.idListeCourses = idListeCourses;
    }

    public Ingredient getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Ingredient idIngredient) {
        this.idIngredient = idIngredient;
    }

}