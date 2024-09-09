package xyz.victorl.scrontchback.model.mapper;

import xyz.victorl.scrontchback.model.dto.IngredientRecetteDto;
import xyz.victorl.scrontchback.model.entity.IngredientRecette;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {IngredientMapper.class, EtapeMapper.class, UniteMesureMapper.class, IngredientDetailsMapper.class})
public interface IngredientRecetteMapper {
    @Mapping(source = "idIngredient.id", target = "ingredient.id")
    @Mapping(source = "idEtape.id", target = "etape.id")
    @Mapping(source = "idUniteMesure.id", target = "uniteMesure.id")
    @Mapping(source = "idIngredientDetails.id", target = "ingredientDetails.id")
    @Mapping(source = "estFacultatif", target = "estFacultatif")
    @Mapping(source = "quantite", target = "quantite")
    IngredientRecette toEntity(IngredientRecetteDto ingredientRecetteDto);
    @Mapping(source = "ingredient.id", target = "idIngredient.id")
    @Mapping(source = "ingredient.libIngredient", target = "idIngredient.libIngredient")
    @Mapping(source = "etape.id", target = "idEtape.id")
    @Mapping(source = "etape.dureeEtape", target = "idEtape.dureeEtape")
    @Mapping(source = "uniteMesure.id", target = "idUniteMesure.id")
    @Mapping(source = "ingredientDetails.id", target = "idIngredientDetails.id")
    @Mapping(source = "estFacultatif", target = "estFacultatif")
    @Mapping(source = "quantite", target = "quantite")
    IngredientRecetteDto toDto(IngredientRecette ingredientRecette);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    IngredientRecette partialUpdate(IngredientRecetteDto ingredientRecetteDto, @MappingTarget IngredientRecette ingredientRecette);

    List<IngredientRecetteDto> toDtoList(List<IngredientRecette> ingredientRecettes);
}