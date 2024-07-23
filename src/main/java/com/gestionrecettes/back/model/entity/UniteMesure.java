package com.gestionrecettes.back.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "unite_mesure")
public class UniteMesure {
    @Id
    @Column(name = "id_unite_mesure", nullable = false)
    private Integer id;

    @Column(name = "lib_unite_mesure", nullable = false, length = 100)
    private String libUniteMesure;

    @OneToMany(mappedBy = "idUniteMesure")
    private Set<IngredientRecette> ingredientRecettes = new LinkedHashSet<>();

}