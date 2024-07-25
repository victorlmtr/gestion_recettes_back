package com.gestionrecettes.back.model.mapper;

import com.gestionrecettes.back.model.dto.RecetteDto;
import com.gestionrecettes.back.model.dto.RegimeRecetteDto;
import com.gestionrecettes.back.model.entity.Recette;
import com.gestionrecettes.back.model.entity.RegimeRecette;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {PaysMapper.class, TypeRecetteMapper.class, RegimeRecetteMapper.class, EtapeMapper.class})
public interface RecetteMapper {
    Recette toEntity(RecetteDto recetteDto);

    @AfterMapping
    default void linkEtapes(@MappingTarget Recette recette) {
        recette.getEtapes().forEach(etape -> etape.setIdRecette(recette));
    }

    RecetteDto toDto(Recette recette);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Recette partialUpdate(RecetteDto recetteDto, @MappingTarget Recette recette);

    List<RecetteDto> toDtoList(List<Recette> recettes);
}