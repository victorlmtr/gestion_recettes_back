package com.gestionrecettes.back.model.entity;

import org.hibernate.Hibernate;
import java.util.Objects;
import jakarta.persistence.*;

@Entity
@Table(name = "cataloguer")
public class Cataloguer {
    @EmbeddedId
    private CataloguerId id;

    @MapsId("idNonConsommable")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_non_consommable", nullable = false)
    private NonConsommable idNonConsommable;

    @MapsId("idListeCourses")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_liste_courses", nullable = false)
    private ListeCourses idListeCourses;

    public CataloguerId getId() {
        return id;
    }

    public void setId(CataloguerId id) {
        this.id = id;
    }

    public NonConsommable getIdNonConsommable() {
        return idNonConsommable;
    }

    public void setIdNonConsommable(NonConsommable idNonConsommable) {
        this.idNonConsommable = idNonConsommable;
    }

    public ListeCourses getIdListeCourses() {
        return idListeCourses;
    }

    public void setIdListeCourses(ListeCourses idListeCourses) {
        this.idListeCourses = idListeCourses;
    }

}