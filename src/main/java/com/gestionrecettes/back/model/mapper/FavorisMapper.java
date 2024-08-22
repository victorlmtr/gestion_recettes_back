package com.gestionrecettes.back.model.mapper;

import com.gestionrecettes.back.model.dto.FavorisDto;
import com.gestionrecettes.back.model.entity.Favoris;
import org.mapstruct.*;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {RecetteMapper.class, UtilisateurMapper.class})
public interface FavorisMapper {
    Favoris toEntity(FavorisDto favorisDto);

    FavorisDto toDto(Favoris favoris);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Favoris partialUpdate(FavorisDto favorisDto, @MappingTarget Favoris favoris);

    List<FavorisDto> toDtoList(List<Favoris> favorites);

}
