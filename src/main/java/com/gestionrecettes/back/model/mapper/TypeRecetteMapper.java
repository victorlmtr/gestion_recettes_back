package com.gestionrecettes.back.model.mapper;

import com.gestionrecettes.back.model.dto.RegimeRecetteDto;
import com.gestionrecettes.back.model.dto.TypeRecetteDto;
import com.gestionrecettes.back.model.entity.RegimeRecette;
import com.gestionrecettes.back.model.entity.TypeRecette;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TypeRecetteMapper {
    TypeRecette toEntity(TypeRecetteDto typeRecetteDto);

    TypeRecetteDto toDto(TypeRecette typeRecette);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TypeRecette partialUpdate(TypeRecetteDto typeRecetteDto, @MappingTarget TypeRecette typeRecette);

    List<TypeRecetteDto> toDtoList(List<TypeRecette> types);
}