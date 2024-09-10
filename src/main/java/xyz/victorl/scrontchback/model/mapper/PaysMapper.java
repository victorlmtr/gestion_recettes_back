package xyz.victorl.scrontchback.model.mapper;

import xyz.victorl.scrontchback.model.dto.PaysDto;
import xyz.victorl.scrontchback.model.entity.Pays;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {ContinentMapper.class})
public interface PaysMapper {
    Pays toEntity(PaysDto paysDto);

    PaysDto toDto(Pays pays);

    List<PaysDto> toDtoList(List<Pays> countries);

    List<Pays> toEntityList(List<PaysDto> paysDtos);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Pays partialUpdate(PaysDto paysDto, @MappingTarget Pays pays);
}