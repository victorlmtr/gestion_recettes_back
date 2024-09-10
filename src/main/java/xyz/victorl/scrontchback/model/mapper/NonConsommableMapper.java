package xyz.victorl.scrontchback.model.mapper;

import xyz.victorl.scrontchback.model.dto.NonConsommableDto;
import xyz.victorl.scrontchback.model.entity.NonConsommable;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface NonConsommableMapper {

    @Mapping(target = "libNonConsommable", source = "libNonConsommable")
    NonConsommable toEntity(NonConsommableDto nonConsommableDto);
    @Mapping(target = "libNonConsommable", source = "libNonConsommable")
    NonConsommableDto toDto(NonConsommable nonConsommable);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    NonConsommable partialUpdate(NonConsommableDto nonConsommableDto, @MappingTarget NonConsommable nonConsommable);
    List<NonConsommableDto> toDtoList(List<NonConsommable> nonConsommables);
}