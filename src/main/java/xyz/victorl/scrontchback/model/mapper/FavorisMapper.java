package xyz.victorl.scrontchback.model.mapper;

import xyz.victorl.scrontchback.model.dto.FavorisDto;
import xyz.victorl.scrontchback.model.entity.Favoris;
import org.mapstruct.*;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {RecetteMapper.class, UtilisateurMapper.class})
public interface FavorisMapper {
    Favoris toEntity(FavorisDto favorisDto);

    FavorisDto toDto(Favoris favoris);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Favoris partialUpdate(FavorisDto favorisDto, @MappingTarget Favoris favoris);

    List<FavorisDto> toDtoList(List<Favoris> favorites);

}
