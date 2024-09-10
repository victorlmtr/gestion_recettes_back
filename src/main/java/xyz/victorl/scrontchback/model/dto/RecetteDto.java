package xyz.victorl.scrontchback.model.dto;

import lombok.Builder;
import lombok.Value;
import xyz.victorl.scrontchback.model.entity.Recette;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;

/**
 * DTO for {@link Recette}
 */
@Builder
@Value
public class RecetteDto implements Serializable {
    Integer id;
    String libRecette;
    String descriptionRecette;
    Integer difficulteRecette;
    Integer nombrePortion;
    String remarqueRecette;
    LocalDate datePublicationRecette;
    String imageRecette;
    PaysDto idPays;
    TypeRecetteDto idTypeRecette;
    Set<RegimeRecetteDto> regimeRecettes;
    Set<EtapeDto> etapes;
    Duration totalTime;
}