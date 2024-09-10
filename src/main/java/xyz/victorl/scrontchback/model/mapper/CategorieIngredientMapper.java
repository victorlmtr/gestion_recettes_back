package xyz.victorl.scrontchback.model.mapper;

import xyz.victorl.scrontchback.model.dto.CategorieIngredientDto;
import xyz.victorl.scrontchback.model.entity.CategorieIngredient;
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