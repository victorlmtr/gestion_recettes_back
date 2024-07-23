package com.gestionrecettes.back.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "continent")
@Getter
@Setter
public class Continent {

    @Id
    @Column(name = "id_continent", nullable = false)
    private Integer id;

    @Column(name = "lib_continent", nullable = false, length = 100)
    private String libContinent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Continent continent = (Continent) o;
        return Objects.equals(id, continent.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
