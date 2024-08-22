package com.gestionrecettes.back.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class IngredientsListId implements java.io.Serializable {
    private static final long serialVersionUID = 6134612271464596039L;
    @Column(name = "id_liste_courses", nullable = false)
    private Integer idListeCourses;

    @Column(name = "id_ingredient", nullable = false)
    private Integer idIngredient;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        IngredientsListId entity = (IngredientsListId) o;
        return Objects.equals(this.idListeCourses, entity.idListeCourses) &&
                Objects.equals(this.idIngredient, entity.idIngredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idListeCourses, idIngredient);
    }

}