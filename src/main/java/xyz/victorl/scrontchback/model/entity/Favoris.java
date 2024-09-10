package xyz.victorl.scrontchback.model.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "favoris")
public class Favoris {
    @EmbeddedId
    private FavorisId id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_recette", nullable = false, insertable = false, updatable = false)
    private Recette recette;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_utilisateur", nullable = false, insertable = false, updatable = false)
    private Utilisateur utilisateur;

    @Column(name = "date_favori", nullable = false)
    private LocalDate dateFavori;


}