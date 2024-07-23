package com.gestionrecettes.back.model.mapper;

import com.gestionrecettes.back.model.dto.IngredientDto;
import com.gestionrecettes.back.model.entity.Ingredient;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface IngredientMapper {
    Ingredient toEntity(IngredientDto ingredientDto);

    IngredientDto toDto(Ingredient ingredient);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Ingredient partialUpdate(IngredientDto ingredientDto, @MappingTarget Ingredient ingredient);

    List<IngredientDto> toDtoList(List<Ingredient> ingredients);
}