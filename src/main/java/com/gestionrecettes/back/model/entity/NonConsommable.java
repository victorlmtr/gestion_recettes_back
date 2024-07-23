package com.gestionrecettes.back.model.entity;

import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "non_consommable")
public class NonConsommable {
    @Id
    @Column(name = "id_non_consommable", nullable = false)
    private Integer id;

    @Column(name = "lib_non_consommable", nullable = false, length = 100)
    private String libNonConsommable;

    @ManyToMany
    @JoinTable(name = "cataloguer",
            joinColumns = @JoinColumn(name = "id_non_consommable"),
            inverseJoinColumns = @JoinColumn(name = "id_liste_courses"))
    private Set<ListeCourses> listeCourses = new LinkedHashSet<>();

    public Set<ListeCourses> getListeCourses() {
        return listeCourses;
    }

    public void setListeCourses(Set<ListeCourses> listeCourses) {
        this.listeCourses = listeCourses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibNonConsommable() {
        return libNonConsommable;
    }

    public void setLibNonConsommable(String libNonConsommable) {
        this.libNonConsommable = libNonConsommable;
    }

}