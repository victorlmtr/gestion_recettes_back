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
@Table(name = "regime_recette")
public class RegimeRecette {
    @Id
    @Column(name = "id_regime_recette", nullable = false)
    private Integer id;

    @Column(name = "lib_regime_recette", nullable = false, length = 50)
    private String libRegimeRecette;

    @Column(name = "icone_regime_recette")
    private byte[] iconeRegimeRecette;

    @ManyToMany
    @JoinTable(name = "categoriser",
            joinColumns = @JoinColumn(name = "id_regime_recette"),
            inverseJoinColumns = @JoinColumn(name = "id_recette"))
    private Set<Recette> recettes = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "choix_categories",
            joinColumns = @JoinColumn(name = "id_regime_recette"),
            inverseJoinColumns = @JoinColumn(name = "id_utilisateur"))
    private Set<Utilisateur> utilisateurs = new LinkedHashSet<>();
}