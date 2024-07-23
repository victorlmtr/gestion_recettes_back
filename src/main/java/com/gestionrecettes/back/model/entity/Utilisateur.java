package com.gestionrecettes.back.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @Column(name = "id_utilisateur", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom_utilisateur", nullable = false, length = 100)
    private String nomUtilisateur;

    @Column(name = "email_utilisateur", nullable = false, length = 150)
    private String emailUtilisateur;

    @Column(name = "mdp_utilisateur", nullable = false, length = 100)
    private  String mdpUtilisateur;

    @Column(name = "date_creation_utilisateur", nullable = false)
    private LocalDate dateCreationUtilisateur;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_role", nullable = false)
    private Role idRole;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getEmailUtilisateur() {
        return emailUtilisateur;
    }

    public void setEmailUtilisateur(String emailUtilisateur) {
        this.emailUtilisateur = emailUtilisateur;
    }

    public  String getMdpUtilisateur() {
        return mdpUtilisateur;
    }

    public void setMdpUtilisateur(String mdpUtilisateur) {
        this.mdpUtilisateur = mdpUtilisateur;
    }

    public LocalDate getDateCreationUtilisateur() {
        return dateCreationUtilisateur;
    }

    public void setDateCreationUtilisateur(LocalDate dateCreationUtilisateur) {
        this.dateCreationUtilisateur = dateCreationUtilisateur;
    }

    @JsonProperty("idRole")
    public Integer getRoleId() {
        return idRole.getId();
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }

}