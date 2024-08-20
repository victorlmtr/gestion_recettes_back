package com.gestionrecettes.back.model.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.gestionrecettes.back.model.entity.NonConsommable}
 */
@Value
public class NonConsommableDto implements Serializable {
    Integer id;
    String libNonConsommable;
}