package com.gestionrecettes.back.model.dto;

import lombok.Data;

@Data

public class MissingIngredientsResponse {
    private long missingIngredientsCount;
    public MissingIngredientsResponse(long missingIngredientsCount) {
        this.missingIngredientsCount = missingIngredientsCount;
    }
}
