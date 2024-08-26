package com.gestionrecettes.back.controller;

import com.gestionrecettes.back.model.dto.*;
import com.gestionrecettes.back.service.CommentaireService;
import com.gestionrecettes.back.service.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecetteController {


    private final RecetteService recetteService;
    private final CommentaireService commentaireService;

    @Autowired
    public RecetteController(RecetteService recetteService, CommentaireService commentaireService) {
        this.recetteService = recetteService;
        this.commentaireService = commentaireService;
    }
    @PostMapping
    public ResponseEntity<RecetteDto> createRecette(@RequestBody RecetteDto recetteDto) {
        RecetteDto createdRecette = recetteService.createRecette(recetteDto);
        return new ResponseEntity<>(createdRecette, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecetteDto> updateRecette(@PathVariable Integer id, @RequestBody RecetteDto recetteDto) {
        RecetteDto updatedRecette = recetteService.updateRecette(recetteDto);
        return new ResponseEntity<>(updatedRecette, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecette(@PathVariable Integer id) {
        recetteService.deleteRecette(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<RecetteDto>> getAllRecettes() {
        List<RecetteDto> recettes = recetteService.getAllRecettes();
        return new ResponseEntity<>(recettes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecetteDto> getRecetteById(@PathVariable Integer id) {
        RecetteDto recette = recetteService.getRecetteById(id);
        return new ResponseEntity<>(recette, HttpStatus.OK);
    }

    @GetMapping("/{id}/ingredients")
    public ResponseEntity<List<IngredientRecetteDto>> getIngredientsForAllSteps(@PathVariable Integer id) {
        List<IngredientRecetteDto> ingredients = recetteService.getIngredientsForAllSteps(id);
        return new ResponseEntity<>(ingredients, HttpStatus.OK);
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<List<CommentaireDto>> getCommentsForRecipe(@PathVariable Integer id) {
        List<CommentaireDto> comments = commentaireService.getCommentsByRecetteId(id);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/{id}/rating-info")
    public ResponseEntity<RatingInfoDto> getRatingInfoForRecipe(@PathVariable Integer id) {
        RatingInfoDto ratingInfo = commentaireService.getRatingInfoByRecetteId(id);
        return new ResponseEntity<>(ratingInfo, HttpStatus.OK);
    }

}
