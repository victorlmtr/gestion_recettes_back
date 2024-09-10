package xyz.victorl.scrontchback.model.mapper;

import xyz.victorl.scrontchback.model.dto.UniteMesureDto;
import xyz.victorl.scrontchback.model.entity.UniteMesure;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UniteMesureMapper {
    UniteMesure toEntity(UniteMesureDto uniteMesureDto);

    UniteMesureDto toDto(UniteMesure uniteMesure);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UniteMesure partialUpdate(UniteMesureDto uniteMesureDto, @MappingTarget UniteMesure uniteMesure);

    List<UniteMesureDto> toDtoList(List<UniteMesure> unitesMesure);
}