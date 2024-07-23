package com.gestionrecettes.back.model.mapper;

import com.gestionrecettes.back.model.dto.CategorieIngredientDto;
import com.gestionrecettes.back.model.dto.EtapeDto;
import com.gestionrecettes.back.model.entity.CategorieIngredient;
import com.gestionrecettes.back.model.entity.Etape;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategorieIngredientMapper {
    CategorieIngredient toEntity(CategorieIngredientDto categorieIngredientDto);

    CategorieIngredientDto toDto(CategorieIngredient categorieIngredient);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CategorieIngredient partialUpdate(CategorieIngredientDto categorieIngredientDto, @MappingTarget CategorieIngredient categorieIngredient);


    List<CategorieIngredientDto> toDtoList(List<CategorieIngredient> categorieIngredients);

    List<CategorieIngredient> toEntityList(List<CategorieIngredientDto> categorieIngredientDtos);

}