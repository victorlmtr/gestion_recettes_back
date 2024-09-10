package xyz.victorl.scrontchback.model.mapper;

import xyz.victorl.scrontchback.model.dto.IngredientDto;
import xyz.victorl.scrontchback.model.entity.Ingredient;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {CategorieIngredientMapper.class})
public interface IngredientMapper {
    @Mapping(target = "libIngredient", source = "libIngredient")
    @Mapping(target = "categorieIngredient", source = "categorieIngredient")
    Ingredient toEntity(IngredientDto ingredientDto);
    @Mapping(target = "libIngredient", source = "libIngredient")
    @Mapping(target = "categorieIngredient", source = "categorieIngredient")
    IngredientDto toDto(Ingredient ingredient);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Ingredient partialUpdate(IngredientDto ingredientDto, @MappingTarget Ingredient ingredient);


    List<IngredientDto> toDtoList(List<Ingredient> ingredients);
}