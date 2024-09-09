package xyz.victorl.scrontchback.model.dto;

import lombok.Value;
import xyz.victorl.scrontchback.model.entity.TypeRecette;

import java.io.Serializable;

/**
 * DTO for {@link TypeRecette}
 */
@Value
public class TypeRecetteDto implements Serializable {
    Integer id;
    String libTypeRecette;
    byte[] iconeTypeRecette;
}