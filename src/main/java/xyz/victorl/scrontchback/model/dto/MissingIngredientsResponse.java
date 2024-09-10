package xyz.victorl.scrontchback.model.dto;

import lombok.Data;

@Data

public class MissingIngredientsResponse {
    private long missingIngredientsCount;
    public MissingIngredientsResponse(long missingIngredientsCount) {
        this.missingIngredientsCount = missingIngredientsCount;
    }
}
