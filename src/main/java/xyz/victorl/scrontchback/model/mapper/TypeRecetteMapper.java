package xyz.victorl.scrontchback.model.mapper;

import xyz.victorl.scrontchback.model.dto.TypeRecetteDto;
import xyz.victorl.scrontchback.model.entity.TypeRecette;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TypeRecetteMapper {
    TypeRecette toEntity(TypeRecetteDto typeRecetteDto);

    TypeRecetteDto toDto(TypeRecette typeRecette);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TypeRecette partialUpdate(TypeRecetteDto typeRecetteDto, @MappingTarget TypeRecette typeRecette);

    List<TypeRecetteDto> toDtoList(List<TypeRecette> types);
}