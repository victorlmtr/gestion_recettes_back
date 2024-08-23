package com.gestionrecettes.back.model.mapper;

import com.gestionrecettes.back.model.dto.DietsListDto;
import com.gestionrecettes.back.model.entity.DietsList;
import org.mapstruct.*;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {UtilisateurMapper.class, RegimeRecetteMapper.class})
public interface DietsListMapper {
    DietsList toEntity(DietsListDto dietsListDto);
    DietsListDto toDto(DietsList dietsList);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DietsList partialUpdate(DietsListDto dietsListDto, @MappingTarget DietsList dietsList);
    List<DietsListDto> toDtoList(List<DietsList> dietsLists);

}
