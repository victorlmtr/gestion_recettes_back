package com.gestionrecettes.back.model.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * DTO for {@link com.gestionrecettes.back.model.entity.Recette}
 */
@Value
public class RecetteDto implements Serializable {
    Integer id;
    String libRecette;
    String descriptionRecette;
    Integer difficulteRecette;
    Integer nombrePortion;
    String remarqueRecette;
    LocalDate datePublicationRecette;
    byte[] imageRecette;
    PaysDto idPays;
    TypeRecetteDto idTypeRecette;
    Set<RegimeRecetteDto> regimeRecettes;
    Set<EtapeDto> etapes;
}