package com.gestionrecettes.back.controller;

import com.gestionrecettes.back.model.dto.CommentaireDto;
import com.gestionrecettes.back.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentaireController {
    @Autowired
    private CommentaireService commentaireService;

    @GetMapping
    public List<CommentaireDto> getAllCommentaires() {
        return commentaireService.getAllCommentaires();
    }

    @GetMapping("/{idUtilisateur}/{idRecette}")
    public CommentaireDto getCommentaireById(
            @PathVariable Integer idUtilisateur,
            @PathVariable Integer idRecette) {
        return commentaireService.getCommentaireById(idUtilisateur, idRecette);
    }
        @PostMapping
        public CommentaireDto createCommentaire(@RequestBody CommentaireDto commentaireDto){
            return commentaireService.createCommentaire(commentaireDto);
        }
        @PutMapping("/{idUtilisateur}/{idRecette}")
        public CommentaireDto updateCommentaire(
                @PathVariable Integer idUtilisateur,
                @PathVariable Integer idRecette,
                @RequestBody CommentaireDto commentaireDto) {
            return commentaireService.updateCommentaire(idUtilisateur, idRecette, commentaireDto);
        }

        @DeleteMapping("/{idUtilisateur}/{idRecette}")
                public void deleteCommentaire(
                        @PathVariable Integer idUtilisateur,
        @PathVariable Integer idRecette) {
        commentaireService.deleteCommentaire(idUtilisateur, idRecette);
        }
}

