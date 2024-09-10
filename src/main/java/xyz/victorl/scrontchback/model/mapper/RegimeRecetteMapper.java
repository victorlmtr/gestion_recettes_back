package xyz.victorl.scrontchback.model.mapper;

import xyz.victorl.scrontchback.model.dto.RegimeRecetteDto;
import xyz.victorl.scrontchback.model.entity.RegimeRecette;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RegimeRecetteMapper {
    RegimeRecette toEntity(RegimeRecetteDto regimeRecetteDto);

    RegimeRecetteDto toDto(RegimeRecette regimeRecette);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    RegimeRecette partialUpdate(RegimeRecetteDto regimeRecetteDto, @MappingTarget RegimeRecette regimeRecette);

    List<RegimeRecetteDto> toDtoList(List<RegimeRecette> regimeRecettes);
}