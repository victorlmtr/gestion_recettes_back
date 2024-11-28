package xyz.victorl.scrontchback.model.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "regime_recette")
public class RegimeRecette {
    @Id
    @Column(name = "id_regime_recette", nullable = false)
    private Integer id;

    @Column(name = "lib_regime_recette", nullable = false, length = 50)
    private String libRegimeRecette;

    @Column(name = "icone_regime_recette", nullable = false)
    private String iconeRegimeRecette; // Updated to String
}
