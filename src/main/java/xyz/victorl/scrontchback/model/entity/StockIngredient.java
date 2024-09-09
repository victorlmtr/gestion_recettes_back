package xyz.victorl.scrontchback.model.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "stock_ingredients")
public class StockIngredient {
    @EmbeddedId
    private StockIngredientId id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_ingredient", nullable = false, insertable = false, updatable = false)
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_utilisateur", nullable = false, insertable = false, updatable = false)
    private Utilisateur utilisateur;

}