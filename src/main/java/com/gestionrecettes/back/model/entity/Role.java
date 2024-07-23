package com.gestionrecettes.back.model.entity;

import org.hibernate.Hibernate;
import jakarta.persistence.*;

@Entity
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibRole() {
        return libRole;
    }

    public void setLibRole(String libRole) {
        this.libRole = libRole;
    }

}