package com.gestionrecettes.back.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class CommentaireId implements java.io.Serializable {
    private static final long serialVersionUID = 1015155802779845985L;
    @Column(name = "id_utilisateur", nullable = false)
    private Integer idUtilisateur;

    @Column(name = "id_recette", nullable = false)
    private Integer idRecette;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CommentaireId entity = (CommentaireId) o;
        return Objects.equals(this.idRecette, entity.idRecette) &&
                Objects.equals(this.idUtilisateur, entity.idUtilisateur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecette, idUtilisateur);
    }

}