package com.gestionrecettes.back.model.dto;

import lombok.Value;

@Value
public class RatingInfoDto {
    Double averageRating;
    Long totalComments;
}
