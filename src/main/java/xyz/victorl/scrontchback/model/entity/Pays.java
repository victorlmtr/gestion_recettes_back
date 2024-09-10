package xyz.victorl.scrontchback.model.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "pays")
public class Pays {
    @Id
    @Column(name = "id_pays", nullable = false)
    private Integer id;

    @Column(name = "lib_pays", nullable = false, length = 100)
    private String libPays;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_continent", nullable = false)
    private Continent idContinent;

    @OneToMany(mappedBy = "idPays")
    private Set<Recette> recettes = new LinkedHashSet<>();

}