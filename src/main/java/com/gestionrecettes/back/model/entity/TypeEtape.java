package com.gestionrecettes.back.model.entity;

import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "type_etape")
public class TypeEtape {
    @Id
    @Column(name = "id_type_etape", nullable = false)
    private Integer id;

    @Column(name = "lib_type_etape", nullable = false, length = 2000)
    private String libTypeEtape;

    @OneToMany(mappedBy = "idTypeEtape")
    private Set<Etape> etapes = new LinkedHashSet<>();

    public Set<Etape> getEtapes() {
        return etapes;
    }

    public void setEtapes(Set<Etape> etapes) {
        this.etapes = etapes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibTypeEtape() {
        return libTypeEtape;
    }

    public void setLibTypeEtape(String libTypeEtape) {
        this.libTypeEtape = libTypeEtape;
    }

}