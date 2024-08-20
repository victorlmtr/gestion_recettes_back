package com.gestionrecettes.back.model.mapper;

import com.gestionrecettes.back.model.dto.CommentaireDto;
import com.gestionrecettes.back.model.entity.Commentaire;
import org.mapstruct.*;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {UtilisateurMapper.class, RecetteMapper.class})
public interface CommentaireMapper {
    Commentaire toEntity(CommentaireDto commentaireDto);

    CommentaireDto toDto(Commentaire commentaire);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Commentaire partialUpdate(CommentaireDto commentaireDto, @MappingTarget Commentaire commentaire);

    List<CommentaireDto> toDtoList(List<Commentaire> commentaires);

}
