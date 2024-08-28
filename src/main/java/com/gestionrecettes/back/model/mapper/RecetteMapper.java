package com.gestionrecettes.back.model.mapper;

import com.gestionrecettes.back.model.dto.RecetteDto;
import com.gestionrecettes.back.model.entity.Recette;
import org.mapstruct.*;

import java.time.OffsetTime;
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
        long totalTime = recette.getEtapes().stream()
                .mapToLong(etape -> {
                    OffsetTime dureeEtape = etape.getDureeEtape();
                    return dureeEtape.getHour() * 60L + dureeEtape.getMinute();
                })
                .sum();
        recetteDtoBuilder.totalTime(totalTime); // Set the calculated total time using the builder
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Recette partialUpdate(RecetteDto recetteDto, @MappingTarget Recette recette);

    List<RecetteDto> toDtoList(List<Recette> recettes);
}