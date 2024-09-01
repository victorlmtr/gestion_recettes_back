package com.gestionrecettes.back.model.mapper;

import com.gestionrecettes.back.model.dto.RecetteDto;
import com.gestionrecettes.back.model.entity.Etape;
import com.gestionrecettes.back.model.entity.Recette;
import org.mapstruct.*;

import java.time.Duration;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {PaysMapper.class, TypeRecetteMapper.class, RegimeRecetteMapper.class, EtapeMapper.class})
public interface RecetteMapper {
    Recette toEntity(RecetteDto recetteDto);

    @AfterMapping
    default void linkEtapes(@MappingTarget Recette recette) {
        recette.getEtapes().forEach(etape -> etape.setRecette(recette));
    }

    RecetteDto toDto(Recette recette);

    @AfterMapping
    default void calculateTotalTime(Recette recette, @MappingTarget RecetteDto.RecetteDtoBuilder recetteDtoBuilder) {
        // Calculate total time as Duration
        Duration totalTime = recette.getEtapes().stream()
                .map(Etape::getDureeEtape)  // Get Duration from each Etape
                .reduce(Duration.ZERO, Duration::plus);  // Sum all Durations

        // Set the calculated total time using the builder
        recetteDtoBuilder.totalTime(totalTime);
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Recette partialUpdate(RecetteDto recetteDto, @MappingTarget Recette recette);

    List<RecetteDto> toDtoList(List<Recette> recettes);
}
