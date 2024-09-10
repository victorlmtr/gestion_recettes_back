package xyz.victorl.scrontchback.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class IngredientRecetteId implements Serializable {

    private static final long serialVersionUID = -3701357569005071273L;

    @Column(name = "id_ingredient", nullable = false)
    private Integer idIngredient;

    @Column(name = "id_etape", nullable = false)
    private Integer idEtape;

    @Column(name = "id_unite_mesure", nullable = false)
    private Integer idUniteMesure;

    @Column(name = "id_ingredient_details", nullable = false)
    private Integer idIngredientDetails;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        IngredientRecetteId entity = (IngredientRecetteId) o;
        return Objects.equals(this.idIngredientDetails, entity.idIngredientDetails) &&
                Objects.equals(this.idEtape, entity.idEtape) &&
                Objects.equals(this.idIngredient, entity.idIngredient) &&
                Objects.equals(this.idUniteMesure, entity.idUniteMesure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIngredientDetails, idEtape, idIngredient, idUniteMesure);
    }
}
