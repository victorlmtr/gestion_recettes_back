package com.gestionrecettes.back.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class RecipeDietId implements java.io.Serializable {
    private static final long serialVersionUID = 1064895161168372647L;
    @Column(name = "id_regime_recette", nullable = false)
    private Integer idRegimeRecette;

    @Column(name = "id_recette", nullable = false)
    private Integer idRecette;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RecipeDietId entity = (RecipeDietId) o;
        return Objects.equals(this.idRegimeRecette, entity.idRegimeRecette) &&
                Objects.equals(this.idRecette, entity.idRecette);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRegimeRecette, idRecette);
    }

}