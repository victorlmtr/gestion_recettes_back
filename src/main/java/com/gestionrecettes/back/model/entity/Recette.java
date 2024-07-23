package com.gestionrecettes.back.model.entity;

import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
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
    private byte[] imageRecette;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_pays", nullable = false)
    private Pays idPays;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_type_recette", nullable = false)
    private TypeRecette idTypeRecette;

    @ManyToMany
    @JoinTable(name = "categoriser",
            joinColumns = @JoinColumn(name = "id_recette"),
            inverseJoinColumns = @JoinColumn(name = "id_regime_recette"))
    private Set<RegimeRecette> regimeRecettes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idRecette")
    private Set<Commentaire> commentaires = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idRecette")
    private Set<Etape> etapes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idRecette")
    private Set<Favoris> favorises = new LinkedHashSet<>();

    public Set<Favoris> getFavorises() {
        return favorises;
    }

    public void setFavorises(Set<Favoris> favorises) {
        this.favorises = favorises;
    }

    public Set<Etape> getEtapes() {
        return etapes;
    }

    public void setEtapes(Set<Etape> etapes) {
        this.etapes = etapes;
    }

    public Set<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(Set<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public Set<RegimeRecette> getRegimeRecettes() {
        return regimeRecettes;
    }

    public void setRegimeRecettes(Set<RegimeRecette> regimeRecettes) {
        this.regimeRecettes = regimeRecettes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibRecette() {
        return libRecette;
    }

    public void setLibRecette(String libRecette) {
        this.libRecette = libRecette;
    }

    public String getDescriptionRecette() {
        return descriptionRecette;
    }

    public void setDescriptionRecette(String descriptionRecette) {
        this.descriptionRecette = descriptionRecette;
    }

    public Integer getDifficulteRecette() {
        return difficulteRecette;
    }

    public void setDifficulteRecette(Integer difficulteRecette) {
        this.difficulteRecette = difficulteRecette;
    }

    public Integer getNombrePortion() {
        return nombrePortion;
    }

    public void setNombrePortion(Integer nombrePortion) {
        this.nombrePortion = nombrePortion;
    }

    public String getRemarqueRecette() {
        return remarqueRecette;
    }

    public void setRemarqueRecette(String remarqueRecette) {
        this.remarqueRecette = remarqueRecette;
    }

    public LocalDate getDatePublicationRecette() {
        return datePublicationRecette;
    }

    public void setDatePublicationRecette(LocalDate datePublicationRecette) {
        this.datePublicationRecette = datePublicationRecette;
    }

    public byte[] getImageRecette() {
        return imageRecette;
    }

    public void setImageRecette(byte[] imageRecette) {
        this.imageRecette = imageRecette;
    }

    public Pays getIdPays() {
        return idPays;
    }

    public void setIdPays(Pays idPays) {
        this.idPays = idPays;
    }

    public TypeRecette getIdTypeRecette() {
        return idTypeRecette;
    }

    public void setIdTypeRecette(TypeRecette idTypeRecette) {
        this.idTypeRecette = idTypeRecette;
    }

}