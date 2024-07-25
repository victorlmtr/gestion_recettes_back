package com.gestionrecettes.back.model.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.gestionrecettes.back.model.entity.UniteMesure}
 */
@Value
public class UniteMesureDto implements Serializable {
    Integer id;
    String libUniteMesure;
}