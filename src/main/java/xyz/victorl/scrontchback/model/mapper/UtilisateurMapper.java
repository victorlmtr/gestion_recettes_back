package xyz.victorl.scrontchback.model.mapper;

import xyz.victorl.scrontchback.model.dto.UtilisateurDto;
import xyz.victorl.scrontchback.model.entity.Utilisateur;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UtilisateurMapper {
    Utilisateur toEntity(UtilisateurDto utilisateurDto);

    UtilisateurDto toDto(Utilisateur utilisateur);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Utilisateur partialUpdate(UtilisateurDto utilisateurDto, @MappingTarget Utilisateur utilisateur);
}