package xyz.victorl.scrontchback.model.mapper;

import xyz.victorl.scrontchback.model.dto.RecipeDietDto;
import xyz.victorl.scrontchback.model.entity.RecipeDiet;
import org.mapstruct.*;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {RegimeRecetteMapper.class, RecetteMapper.class})
public interface RecipeDietMapper {
    RecipeDiet toEntity(RecipeDietDto recipeDietDto);

    RecipeDietDto toDto(RecipeDiet recipeDiet);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    RecipeDiet partialUpdate(RecipeDietDto recipeDietDto, @MappingTarget RecipeDiet recipeDiet);

    List<RecipeDietDto> toDtoList(List<RecipeDiet> recipeDiets);

}
