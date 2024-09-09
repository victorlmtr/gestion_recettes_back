package xyz.victorl.scrontchback.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "type_etape")
public class TypeEtape {
    @Id
    @Column(name = "id_type_etape", nullable = false)
    private Integer id;

    @Column(name = "lib_type_etape", nullable = false, length = 2000)
    private String libTypeEtape;

}