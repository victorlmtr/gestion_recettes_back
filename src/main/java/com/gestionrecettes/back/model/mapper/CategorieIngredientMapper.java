package com.gestionrecettes.back.model.mapper;

import com.gestionrecettes.back.model.dto.CategorieIngredientDto;
import com.gestionrecettes.back.model.entity.CategorieIngredient;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {IngredientMapper.class})
public interface CategorieIngredientMapper {
    CategorieIngredient toEntity(CategorieIngredientDto categorieIngredientDto);

    @AfterMapping
    default void linkIngredients(@MappingTarget CategorieIngredient categorieIngredient) {
        categorieIngredient.getIngredients().forEach(ingredient -> ingredient.setIdCategorieIngredient(categorieIngredient));
    }

    CategorieIngredientDto toDto(CategorieIngredient categorieIngredient);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CategorieIngredient partialUpdate(CategorieIngredientDto categorieIngredientDto, @MappingTarget CategorieIngredient categorieIngredient);

    List<CategorieIngredientDto> toDtoList(List<CategorieIngredient> categories);
}