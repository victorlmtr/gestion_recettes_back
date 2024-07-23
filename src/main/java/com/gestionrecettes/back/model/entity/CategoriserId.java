package com.gestionrecettes.back.model.entity;

import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.Objects;

@Embeddable
public class CategoriserId implements java.io.Serializable {
    private static final long serialVersionUID = 1064895161168372647L;
    @Column(name = "id_regime_recette", nullable = false)
    private Integer idRegimeRecette;

    @Column(name = "id_recette", nullable = false)
    private Integer idRecette;

    public Integer getIdRegimeRecette() {
        return idRegimeRecette;
    }

    public void setIdRegimeRecette(Integer idRegimeRecette) {
        this.idRegimeRecette = idRegimeRecette;
    }

    public Integer getIdRecette() {
        return idRecette;
    }

    public void setIdRecette(Integer idRecette) {
        this.idRecette = idRecette;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CategoriserId entity = (CategoriserId) o;
        return Objects.equals(this.idRegimeRecette, entity.idRegimeRecette) &&
                Objects.equals(this.idRecette, entity.idRecette);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRegimeRecette, idRecette);
    }

}