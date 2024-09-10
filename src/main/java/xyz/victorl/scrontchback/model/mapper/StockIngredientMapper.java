package xyz.victorl.scrontchback.model.mapper;

import xyz.victorl.scrontchback.model.dto.StockIngredientDto;
import xyz.victorl.scrontchback.model.entity.StockIngredient;
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
