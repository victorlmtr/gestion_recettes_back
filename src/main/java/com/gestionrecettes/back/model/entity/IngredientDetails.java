package com.gestionrecettes.back.model.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "ingredient_details")
public class IngredientDetails {
    @Id
    @Column(name = "id_ingredient_details", nullable = false)
    private Integer id;

    @Column(name = "lib_ingredient_details", nullable = false, length = 2000)
    private String libIngredientDetails;

    @OneToMany(mappedBy = "id.idIngredientDetails")
    private Set<IngredientRecette> ingredientRecettes = new LinkedHashSet<>();

}