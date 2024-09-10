package xyz.victorl.scrontchback.model.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "type_recette")
public class TypeRecette {
    @Id
    @Column(name = "id_type_recette", nullable = false)
    private Integer id;

    @Column(name = "lib_type_recette", nullable = false, length = 50)
    private String libTypeRecette;

    @Column(name = "icone_type_recette", nullable = false)
    private byte[] iconeTypeRecette;

    @OneToMany(mappedBy = "idTypeRecette")
    private Set<Recette> recettes = new LinkedHashSet<>();

}