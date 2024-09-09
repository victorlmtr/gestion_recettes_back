package xyz.victorl.scrontchback.model.dto;

import lombok.Value;

import java.io.Serializable;

@Value
public class NonFoodListDto implements Serializable {
    Integer idListeCourses;
    Integer idNonConsommable;
}
