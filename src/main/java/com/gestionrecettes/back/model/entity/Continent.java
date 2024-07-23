package com.gestionrecettes.back.model.entity;

import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "continent")
public class Continent {

    @Id
    @Column(name = "id_continent", nullable = false)
    private Integer id;

    @Column(name = "lib_continent", nullable = false, length = 100)
    private String libContinent;
}
