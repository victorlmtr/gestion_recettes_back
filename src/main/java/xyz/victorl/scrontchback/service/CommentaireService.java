package xyz.victorl.scrontchback.service;

import xyz.victorl.scrontchback.model.dto.CommentaireDto;
import xyz.victorl.scrontchback.model.dto.RatingInfoDto;
import xyz.victorl.scrontchback.model.entity.Commentaire;
import xyz.victorl.scrontchback.model.entity.CommentaireId;
import xyz.victorl.scrontchback.model.mapper.CommentaireMapper;
import xyz.victorl.scrontchback.model.mapper.EtapeMapper;
import xyz.victorl.scrontchback.model.mapper.RegimeRecetteMapper;
import xyz.victorl.scrontchback.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentaireService {

    private final CommentaireRepository commentaireRepository;
    private final CommentaireMapper commentaireMapper;
    private final RegimeRecetteMapper regimeRecetteMapper;
    private final EtapeMapper etapeMapper;

    @Autowired
    public CommentaireService(CommentaireRepository commentaireRepository, CommentaireMapper commentaireMapper, RegimeRecetteMapper regimeRecetteMapper, EtapeMapper etapeMapper) {
        this.commentaireRepository = commentaireRepository;
        this.commentaireMapper = commentaireMapper;
        this.regimeRecetteMapper = regimeRecetteMapper;
        this.etapeMapper = etapeMapper;
    }

    public List<CommentaireDto> getAllCommentaires() {
        List<Commentaire> commentaires = commentaireRepository.findAll();
        return commentaires.stream()
                .map(commentaireMapper::toDto)
                .toList();
    }

    public CommentaireDto getCommentaireById(Integer idUtilisateur, Integer idRecette) {
        CommentaireId id = new CommentaireId();
        id.setIdUtilisateur(idUtilisateur);
        id.setIdRecette(idRecette);
        Commentaire commentaire = commentaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        return commentaireMapper.toDto(commentaire);
    }

    @Transactional
    public CommentaireDto createCommentaire(CommentaireDto commentaireDto) {
        Commentaire commentaire = commentaireMapper.toEntity(commentaireDto);
        CommentaireId id = new CommentaireId();
        id.setIdUtilisateur(commentaireDto.getIdUtilisateur().getId());
        id.setIdRecette(commentaireDto.getIdRecette().getId());
        commentaire.setId(id);

        Commentaire savedCommentaire = commentaireRepository.save(commentaire);
        return commentaireMapper.toDto(savedCommentaire);
    }

    @Transactional
    public CommentaireDto updateCommentaire(Integer idUtilisateur, Integer idRecette, CommentaireDto commentaireDto) {
        CommentaireId id = new CommentaireId();
        id.setIdUtilisateur(idUtilisateur);
        id.setIdRecette(idRecette);
        Commentaire commentaire = commentaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        // Updating the comment fields from DTO
        commentaire.setCommentaireAvis(commentaireDto.getCommentaireAvis());
        commentaire.setDateCommentaire(commentaireDto.getDateCommentaire());
        commentaire.setNoteAvis(commentaireDto.getNoteAvis());

        Commentaire updatedCommentaire = commentaireRepository.save(commentaire);
        return commentaireMapper.toDto(updatedCommentaire);
    }

    @Transactional
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
