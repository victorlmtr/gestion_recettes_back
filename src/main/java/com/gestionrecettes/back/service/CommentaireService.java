package com.gestionrecettes.back.service;

import com.gestionrecettes.back.model.dto.*;
import com.gestionrecettes.back.model.entity.Commentaire;
import com.gestionrecettes.back.model.entity.CommentaireId;
import com.gestionrecettes.back.model.mapper.CommentaireMapper;
import com.gestionrecettes.back.model.mapper.RegimeRecetteMapperImpl;
import com.gestionrecettes.back.model.mapper.EtapeMapperImpl;
import com.gestionrecettes.back.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentaireService {

    private final CommentaireRepository commentaireRepository;
    private final CommentaireMapper commentaireMapper;
    private final RegimeRecetteMapperImpl regimeRecetteMapper;
    private final EtapeMapperImpl etapeMapper;

    @Autowired
    public CommentaireService(CommentaireRepository commentaireRepository, CommentaireMapper commentaireMapper, RegimeRecetteMapperImpl regimeRecetteMapper, EtapeMapperImpl etapeMapper) {
        this.commentaireRepository = commentaireRepository;
        this.commentaireMapper = commentaireMapper;
        this.regimeRecetteMapper = regimeRecetteMapper;
        this.etapeMapper = etapeMapper;
    }

    public List<CommentaireDto> getAllCommentaires() {
        List<Commentaire> commentaires = commentaireRepository.findAll();
        return commentaires.stream()
                .map(commentaire -> new CommentaireDto(
                        new UtilisateurDto(
                                commentaire.getUtilisateur().getId(),
                                commentaire.getUtilisateur().getNomUtilisateur(),
                                commentaire.getUtilisateur().getEmailUtilisateur(),
                                commentaire.getUtilisateur().getMdpUtilisateur(),
                                commentaire.getUtilisateur().getDateCreationUtilisateur()
                        ),
                        new RecetteDto(
                                commentaire.getRecette().getId(),
                                commentaire.getRecette().getLibRecette(),
                                commentaire.getRecette().getDescriptionRecette(),
                                commentaire.getRecette().getDifficulteRecette(),
                                commentaire.getRecette().getNombrePortion(),
                                commentaire.getRecette().getRemarqueRecette(),
                                commentaire.getRecette().getDatePublicationRecette(),
                                commentaire.getRecette().getImageRecette(),
                                new PaysDto(
                                        commentaire.getRecette().getIdPays().getId(),
                                        commentaire.getRecette().getIdPays().getLibPays(),
                                        new ContinentDto(
                                                commentaire.getRecette().getIdPays().getIdContinent().getId(),
                                                commentaire.getRecette().getIdPays().getIdContinent().getLibContinent()
                                        )
                                ),
                                new TypeRecetteDto(
                                        commentaire.getRecette().getIdTypeRecette().getId(),
                                        commentaire.getRecette().getIdTypeRecette().getLibTypeRecette(),
                                        commentaire.getRecette().getIdTypeRecette().getIconeTypeRecette()
                                ),
                                commentaire.getRecette().getRegimeRecettes().stream()
                                        .map(regimeRecetteMapper::toDto)
                                        .collect(Collectors.toSet()),
                                commentaire.getRecette().getEtapes().stream()
                                        .map(etapeMapper::toDto)
                                        .collect(Collectors.toSet())
                        ),
                        commentaire.getNoteAvis(),
                        commentaire.getCommentaireAvis(),
                        commentaire.getDateCommentaire()
                ))
                .toList();
    }

    public CommentaireDto getCommentaireById(Integer idUtilisateur, Integer idRecette) {
        CommentaireId id = new CommentaireId();
        id.setIdUtilisateur(idUtilisateur);
        id.setIdRecette(idRecette);
        Commentaire commentaire = commentaireRepository.findById(id).orElseThrow();
        return new CommentaireDto(
                new UtilisateurDto(
                        commentaire.getUtilisateur().getId(),
                        commentaire.getUtilisateur().getNomUtilisateur(),
                        commentaire.getUtilisateur().getEmailUtilisateur(),
                        commentaire.getUtilisateur().getMdpUtilisateur(),
                        commentaire.getUtilisateur().getDateCreationUtilisateur()
                ),
                new RecetteDto(
                        commentaire.getRecette().getId(),
                        commentaire.getRecette().getLibRecette(),
                        commentaire.getRecette().getDescriptionRecette(),
                        commentaire.getRecette().getDifficulteRecette(),
                        commentaire.getRecette().getNombrePortion(),
                        commentaire.getRecette().getRemarqueRecette(),
                        commentaire.getRecette().getDatePublicationRecette(),
                        commentaire.getRecette().getImageRecette(),
                        new PaysDto(
                                commentaire.getRecette().getIdPays().getId(),
                                commentaire.getRecette().getIdPays().getLibPays(),
                                new ContinentDto(
                                        commentaire.getRecette().getIdPays().getIdContinent().getId(),
                                        commentaire.getRecette().getIdPays().getIdContinent().getLibContinent()
                                )
                        ),
                        new TypeRecetteDto(
                                commentaire.getRecette().getIdTypeRecette().getId(),
                                commentaire.getRecette().getIdTypeRecette().getLibTypeRecette(),
                                commentaire.getRecette().getIdTypeRecette().getIconeTypeRecette()
                        ),
                        commentaire.getRecette().getRegimeRecettes().stream()
                                .map(regimeRecetteMapper::toDto)
                                .collect(Collectors.toSet()),
                        commentaire.getRecette().getEtapes().stream()
                                .map(etapeMapper::toDto)
                                .collect(Collectors.toSet())
                ),
                commentaire.getNoteAvis(),
                commentaire.getCommentaireAvis(),
                commentaire.getDateCommentaire()
        );
    }

    public CommentaireDto createCommentaire(CommentaireDto commentaireDto) {
        Commentaire commentaire = commentaireMapper.toEntity(commentaireDto);
        CommentaireId id = new CommentaireId();
        id.setIdUtilisateur(commentaireDto.getIdUtilisateur().getId());
        id.setIdRecette(commentaireDto.getIdRecette().getId());
        commentaire.setId(id);

        Commentaire savedCommentaire = commentaireRepository.save(commentaire);
        return commentaireMapper.toDto(savedCommentaire);
    }

    public CommentaireDto updateCommentaire(Integer idUtilisateur, Integer idRecette, CommentaireDto commentaireDto) {
        CommentaireId id = new CommentaireId();
        id.setIdUtilisateur(idUtilisateur);
        id.setIdRecette(idRecette);
        Commentaire commentaire = commentaireRepository.findById(id).orElseThrow();
        commentaire.setCommentaireAvis(commentaireDto.getCommentaireAvis());
        commentaire.setDateCommentaire(commentaireDto.getDateCommentaire());
        commentaire.setNoteAvis(commentaireDto.getNoteAvis());
        Commentaire updatedCommentaire = commentaireRepository.save(commentaire);
        return commentaireMapper.toDto(updatedCommentaire);
    }

    public void deleteCommentaire(Integer idUtilisateur, Integer idRecette) {
        CommentaireId id = new CommentaireId();
        id.setIdUtilisateur(idUtilisateur);
        id.setIdRecette(idRecette);
        commentaireRepository.deleteById(id);
    }
    public List<CommentaireDto> getCommentsByRecetteId(Integer recetteId) {
        List<Commentaire> commentaires = commentaireRepository.findByRecetteId(recetteId);
        return commentaires.stream()
                .map(commentaireMapper::toDto)
                .toList();
    }

    public RatingInfoDto getRatingInfoByRecetteId(Integer recetteId) {
        List<Commentaire> commentaires = commentaireRepository.findByRecetteId(recetteId);

        Double averageRating = commentaires.stream()
                .mapToDouble(Commentaire::getNoteAvis)
                .average()
                .orElse(0.0);

        Long totalComments = (long) commentaires.size();

        return new RatingInfoDto(averageRating, totalComments);
    }
}