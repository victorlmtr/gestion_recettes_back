package xyz.victorl.scrontchback.model.dto;

import lombok.Value;
import xyz.victorl.scrontchback.model.entity.UniteMesure;

import java.io.Serializable;

/**
 * DTO for {@link UniteMesure}
 */
@Value
public class UniteMesureDto implements Serializable {
    Integer id;
    String libUniteMesure;
}