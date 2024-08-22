package com.gestionrecettes.back.model.dto;

import lombok.Value;

import java.io.Serializable;

@Value
public class NonFoodListDto implements Serializable {
    Integer idListeCourses;
    Integer idNonConsommable;
}
