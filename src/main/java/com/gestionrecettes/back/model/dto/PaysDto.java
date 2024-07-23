package com.gestionrecettes.back.model.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.gestionrecettes.back.model.entity.Pays}
 */
@Value
public class PaysDto implements Serializable {
    Integer id;
    String libPays;
    ContinentDto idContinent;
}