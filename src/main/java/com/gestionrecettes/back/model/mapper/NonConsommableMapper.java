package com.gestionrecettes.back.model.mapper;

import com.gestionrecettes.back.model.dto.NonConsommableDto;
import com.gestionrecettes.back.model.entity.NonConsommable;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface NonConsommableMapper {
    NonConsommable toEntity(NonConsommableDto nonConsommableDto);

    NonConsommableDto toDto(NonConsommable nonConsommable);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    NonConsommable partialUpdate(NonConsommableDto nonConsommableDto, @MappingTarget NonConsommable nonConsommable);

    List<NonConsommableDto> toDtoList(List<NonConsommable> nonConsommables);
}