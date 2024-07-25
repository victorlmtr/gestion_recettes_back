package com.gestionrecettes.back.model.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.gestionrecettes.back.model.entity.RegimeRecette}
 */
@Value
public class RegimeRecetteDto implements Serializable {
    Integer id;
    String libRegimeRecette;
    byte[] iconeRegimeRecette;
}