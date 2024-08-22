package com.gestionrecettes.back.model.mapper;

import com.gestionrecettes.back.model.dto.CategorieIngredientDto;
import com.gestionrecettes.back.model.dto.IngredientDto;
import com.gestionrecettes.back.model.dto.ListeCoursesDto;
import com.gestionrecettes.back.model.dto.NonConsommableDto;
import com.gestionrecettes.back.model.entity.*;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IngredientMapper.class, NonConsommableMapper.class, CategorieIngredientMapper.class})
public interface ListeCoursesMapper {

    @Mapping(target = "ingredients", source = "ingredientDtoList", qualifiedByName = "mapIngredientDtoToEntity")
    @Mapping(target = "nonFoodItems", source = "nonConsommableDtoList", qualifiedByName = "mapNonConsommableDtoToEntity")
    ListeCourses toEntity(ListeCoursesDto dto);

    @Mapping(source = "ingredients", target = "ingredientDtoList", qualifiedByName = "mapIngredientEntityToDtoList")
    @Mapping(source = "nonFoodItems", target = "nonConsommableDtoList", qualifiedByName = "mapNonConsommableEntityToDtoList")
    ListeCoursesDto toDto(ListeCourses entity);

    // Custom mapping methods for IngredientsList
    @Named("mapIngredientDtoToEntity")
    default IngredientsList mapIngredientDtoToEntity(IngredientDto dto) {
        if (dto == null) {
            return null;
        }
        IngredientsListId ingredientsListId = new IngredientsListId();
        ingredientsListId.setIdIngredient(dto.getId());
        // Assuming idListeCourses is set elsewhere
        IngredientsList ingredientsList = new IngredientsList();
        ingredientsList.setId(ingredientsListId);
        return ingredientsList;
    }

    @Named("mapIngredientEntityToDtoList")
    default IngredientDto mapIngredientEntityToDto(IngredientsList ingredientsList) {
        if (ingredientsList == null) {
            return null;
        }
        Integer id = ingredientsList.getId().getIdIngredient();
        Ingredient ingredient = ingredientsList.getIdIngredient(); // Fetch the full Ingredient entity

        return new IngredientDto(
                id,
                ingredient != null ? ingredient.getLibIngredient() : null,
                ingredient != null ? mapCategorieIngredientToDto(ingredient.getCategorieIngredient()) : null
        );
    }

    // Custom mapping methods for NonFoodList
    @Named("mapNonConsommableDtoToEntity")
    default NonFoodList mapNonConsommableDtoToEntity(NonConsommableDto dto) {
        if (dto == null) {
            return null;
        }
        NonFoodListId nonFoodListId = new NonFoodListId();
        nonFoodListId.setIdNonConsommable(dto.getId());
        // Assuming idListeCourses is set elsewhere
        NonFoodList nonFoodList = new NonFoodList();
        nonFoodList.setId(nonFoodListId);
        return nonFoodList;
    }

    @Named("mapNonConsommableEntityToDtoList")
    default NonConsommableDto mapNonConsommableEntityToDto(NonFoodList nonFoodList) {
        if (nonFoodList == null) {
            return null;
        }
        Integer id = nonFoodList.getId().getIdNonConsommable();
        NonConsommable nonConsommable = nonFoodList.getIdNonConsommable(); // Fetch the full NonConsommable entity

        return new NonConsommableDto(
                id,
                nonConsommable != null ? nonConsommable.getLibNonConsommable() : null
        );
    }

    // Helper methods
    @Named("mapCategorieIngredientToDto")
    default CategorieIngredientDto mapCategorieIngredientToDto(CategorieIngredient categorieIngredient) {
        if (categorieIngredient == null) {
            return null;
        }
        return new CategorieIngredientDto(
                categorieIngredient.getId(),
                categorieIngredient.getLibCategorieIngredient(),
                categorieIngredient.getIconeCategorie()
        );
    }

    List<ListeCoursesDto> toDtoList(List<ListeCourses> listesCourses);
}
