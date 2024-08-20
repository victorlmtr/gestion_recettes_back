package com.gestionrecettes.back.model.mapper;

import com.gestionrecettes.back.model.dto.UtilisateurDto;
import com.gestionrecettes.back.model.entity.Utilisateur;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UtilisateurMapper {
    Utilisateur toEntity(UtilisateurDto utilisateurDto);

    UtilisateurDto toDto(Utilisateur utilisateur);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Utilisateur partialUpdate(UtilisateurDto utilisateurDto, @MappingTarget Utilisateur utilisateur);
}