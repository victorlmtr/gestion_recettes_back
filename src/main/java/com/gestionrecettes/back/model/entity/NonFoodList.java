package com.gestionrecettes.back.model.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "cataloguer")
public class NonFoodList {
    @EmbeddedId
    private NonFoodListId id;

    @MapsId("idNonConsommable")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_non_consommable", nullable = false)
    private NonConsommable idNonConsommable;

    @MapsId("idListeCourses")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_liste_courses", nullable = false)
    private ListeCourses idListeCourses;
    
}