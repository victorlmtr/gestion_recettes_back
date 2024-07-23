package com.gestionrecettes.back.model.entity;

import org.hibernate.Hibernate;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class CataloguerId implements java.io.Serializable {
    private static final long serialVersionUID = -5746264720144607969L;
    @Column(name = "id_non_consommable", nullable = false)
    private Integer idNonConsommable;

    @Column(name = "id_liste_courses", nullable = false)
    private Integer idListeCourses;

    public Integer getIdNonConsommable() {
        return idNonConsommable;
    }

    public void setIdNonConsommable(Integer idNonConsommable) {
        this.idNonConsommable = idNonConsommable;
    }

    public Integer getIdListeCourses() {
        return idListeCourses;
    }

    public void setIdListeCourses(Integer idListeCourses) {
        this.idListeCourses = idListeCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CataloguerId entity = (CataloguerId) o;
        return Objects.equals(this.idNonConsommable, entity.idNonConsommable) &&
                Objects.equals(this.idListeCourses, entity.idListeCourses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNonConsommable, idListeCourses);
    }

}