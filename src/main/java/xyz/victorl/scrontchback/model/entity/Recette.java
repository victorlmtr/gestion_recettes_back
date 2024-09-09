package xyz.victorl.scrontchback.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "recette")
public class Recette {
    @Id
    @Column(name = "id_recette", nullable = false)
    private Integer id;

    @Column(name = "lib_recette", nullable = false, length = 100)
    private String libRecette;

    @Column(name = "description_recette", nullable = false, length = 2000)
    private String descriptionRecette;

    @Column(name = "difficulte_recette", nullable = false)
    private Integer difficulteRecette;

    @Column(name = "nombre_portion", nullable = false)
    private Integer nombrePortion;

    @Column(name = "remarque_recette", nullable = false, length = 2000)
    private String remarqueRecette;

    @Column(name = "date_publication_recette", nullable = false)
    private LocalDate datePublicationRecette;

    @Column(name = "image_recette")
    private String imageRecette;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_pays", nullable = false)
    private Pays idPays;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_type_recette", nullable = false)
    private TypeRecette idTypeRecette;

    @ManyToMany
    @JoinTable(name = "categoriser",
            joinColumns = @JoinColumn(name = "id_recette"),
            inverseJoinColumns = @JoinColumn(name = "id_regime_recette"))
    @JsonManagedReference
    private Set<RegimeRecette> regimeRecettes = new LinkedHashSet<>();


    @OneToMany(mappedBy = "recette")
    @JsonManagedReference
    private Set<Etape> etapes = new LinkedHashSet<>();

    @Transient // for calculated fields
    private Duration totalTime;

    public Duration getTotalTime() {
        if (etapes != null) {
            return etapes.stream()
                    .map(Etape::getDureeEtape)
                    .reduce(Duration.ZERO, Duration::plus);
        }
        return Duration.ZERO;
    }
}