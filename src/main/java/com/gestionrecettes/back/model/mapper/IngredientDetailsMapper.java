package com.gestionrecettes.back.model.mapper;

import com.gestionrecettes.back.model.dto.IngredientDetailsDto;
import com.gestionrecettes.back.model.entity.IngredientDetails;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface IngredientDetailsMapper {
    IngredientDetails toEntity(IngredientDetailsDto ingredientDetailsDto);

    IngredientDetailsDto toDto(IngredientDetails ingredientDetails);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    IngredientDetails partialUpdate(IngredientDetailsDto ingredientDetailsDto, @MappingTarget IngredientDetails ingredientDetails);

    List<IngredientDetailsDto> toDtoList(List<IngredientDetails> details);
}