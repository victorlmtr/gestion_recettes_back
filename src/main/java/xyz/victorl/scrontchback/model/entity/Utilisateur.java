package xyz.victorl.scrontchback.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.time.LocalDate;

@Setter
@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Getter
    @Id
    @Column(name = "id_utilisateur", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Column(name = "nom_utilisateur", nullable = false, length = 100)
    private String nomUtilisateur;

    @Getter
    @Column(name = "email_utilisateur", nullable = false, length = 150)
    private String emailUtilisateur;

    @Getter
    @Column(name = "mdp_utilisateur", nullable = false, length = 100)
    private  String mdpUtilisateur;

    @Getter
    @Column(name = "date_creation_utilisateur", nullable = false)
    private LocalDate dateCreationUtilisateur;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_role", nullable = false)
    private Role idRole;
    @JsonProperty("idRole")
    public Integer getRoleId() {
        return idRole.getId();
    }

}