package com.gestionrecettes.back.model.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.gestionrecettes.back.model.entity.TypeRecette}
 */
@Value
public class TypeRecetteDto implements Serializable {
    Integer id;
    String libTypeRecette;
    byte[] iconeTypeRecette;
}