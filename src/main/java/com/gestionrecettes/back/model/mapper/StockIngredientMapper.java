package com.gestionrecettes.back.model.mapper;

import com.gestionrecettes.back.model.dto.StockIngredientDto;
import com.gestionrecettes.back.model.entity.StockIngredient;
import org.mapstruct.*;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {IngredientMapper.class, UtilisateurMapper.class})
public interface StockIngredientMapper {
    StockIngredient toEntity(StockIngredientDto stockIngredientDto);

    StockIngredientDto toDto(StockIngredient stockIngredient);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    StockIngredient partialUpdate(StockIngredientDto stockIngredientDto, @MappingTarget StockIngredient stockIngredient);

    List<StockIngredientDto> toDtoList(List<StockIngredient> stocksIngredient);

}
