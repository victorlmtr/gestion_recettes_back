package com.gestionrecettes.back.model.mapper;

import com.gestionrecettes.back.model.dto.ContinentDto;
import com.gestionrecettes.back.model.dto.EtapeDto;
import com.gestionrecettes.back.model.entity.Continent;
import com.gestionrecettes.back.model.entity.Etape;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EtapeMapper {
    Etape toEntity(EtapeDto etapeDto);

    EtapeDto toDto(Etape etape);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Etape partialUpdate(EtapeDto etapeDto, @MappingTarget Etape etape);

    List<EtapeDto> toDtoList(List<Etape> etapes);

    List<Etape> toEntityList(List<EtapeDto> etapeDtos);

}