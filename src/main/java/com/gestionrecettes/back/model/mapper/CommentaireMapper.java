package com.gestionrecettes.back.model.mapper;

import com.gestionrecettes.back.model.dto.CommentaireDto;
import com.gestionrecettes.back.model.entity.Commentaire;
import org.mapstruct.*;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {UtilisateurMapper.class, RecetteMapper.class})
public interface CommentaireMapper {

    @Mapping(target = "id.idUtilisateur", source = "idUtilisateur.id")
    @Mapping(target = "id.idRecette", source = "idRecette.id")
    Commentaire toEntity(CommentaireDto commentaireDto);
    @Mapping(source = "id.idUtilisateur", target = "idUtilisateur.id")
    @Mapping(source = "id.idRecette", target = "idRecette.id")
    CommentaireDto toDto(Commentaire commentaire);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Commentaire partialUpdate(CommentaireDto commentaireDto, @MappingTarget Commentaire commentaire);

    List<CommentaireDto> toDtoList(List<Commentaire> commentaires);

}
