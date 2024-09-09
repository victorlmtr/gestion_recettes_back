package xyz.victorl.scrontchback.model.mapper;

import xyz.victorl.scrontchback.model.dto.IngredientsListDto;
import xyz.victorl.scrontchback.model.entity.Ingredient;
import xyz.victorl.scrontchback.model.entity.IngredientsList;
import xyz.victorl.scrontchback.model.entity.ListeCourses;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IngredientsListMapper {

    @Mapping(target = "idListeCourses", source = "id.idListeCourses")
    @Mapping(target = "idIngredient", source = "id.idIngredient")
    IngredientsListDto toDto(IngredientsList entity);

    @Mapping(target = "id.idListeCourses", source = "idListeCourses")
    @Mapping(target = "id.idIngredient", source = "idIngredient")
    IngredientsList toEntity(IngredientsListDto dto);

    // Custom mapping methods
    default ListeCourses map(Integer idListeCourses) {
        if (idListeCourses == null) {
            return null;
        }
        ListeCourses listeCourses = new ListeCourses();
        listeCourses.setId(idListeCourses);
        return listeCourses;
    }

    default Ingredient mapIngredient(Integer idIngredient) {
        if (idIngredient == null) {
            return null;
        }
        Ingredient ingredient = new Ingredient();
        ingredient.setId(idIngredient);
        return ingredient;
    }

    default Integer map(ListeCourses listeCourses) {
        return listeCourses != null ? listeCourses.getId() : null;
    }

    default Integer mapIngredient(Ingredient ingredient) {
        return ingredient != null ? ingredient.getId() : null;
    }
}

