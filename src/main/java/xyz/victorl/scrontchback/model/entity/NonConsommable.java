package xyz.victorl.scrontchback.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "non_consommable")
public class NonConsommable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_non_consommable", nullable = false)
    private Integer id;

    @Column(name = "lib_non_consommable", nullable = false, length = 100)
    private String libNonConsommable;

}