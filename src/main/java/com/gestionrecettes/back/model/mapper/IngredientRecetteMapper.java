package com.gestionrecettes.back.model.mapper;

import com.gestionrecettes.back.model.dto.IngredientRecetteDto;
import com.gestionrecettes.back.model.entity.IngredientRecette;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {IngredientMapper.class, EtapeMapper.class, UniteMesureMapper.class, IngredientDetailsMapper.class})
public interface IngredientRecetteMapper {
    IngredientRecette toEntity(IngredientRecetteDto ingredientRecetteDto);

    IngredientRecetteDto toDto(IngredientRecette ingredientRecette);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    IngredientRecette partialUpdate(IngredientRecetteDto ingredientRecetteDto, @MappingTarget IngredientRecette ingredientRecette);

    List<IngredientRecetteDto> toDtoList(List<IngredientRecette> ingredientRecettes);
}