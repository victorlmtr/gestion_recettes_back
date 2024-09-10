package xyz.victorl.scrontchback.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "id_role", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "lib_role", nullable = false, length = 50)
    private String libRole;



    public Role() {}

    public Role(String libRole) {
        this.libRole = libRole;
    }

}