package xyz.victorl.scrontchback.model.dto;

import lombok.Value;
import xyz.victorl.scrontchback.model.entity.RegimeRecette;

import java.io.Serializable;

/**
 * DTO for {@link RegimeRecette}
 */
@Value
public class RegimeRecetteDto implements Serializable {
    Integer id;
    String libRegimeRecette;
    String iconeRegimeRecette;
}