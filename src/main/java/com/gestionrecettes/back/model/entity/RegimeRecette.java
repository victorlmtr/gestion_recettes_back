package com.gestionrecettes.back.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

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

    @Column(name = "icone_regime_recette")
    private byte[] iconeRegimeRecette;

}