package com.gestionrecettes.back.controller;

import com.gestionrecettes.back.model.dto.RecetteDto;
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

    @Autowired
    public RecetteController(RecetteService recetteService) {
        this.recetteService = recetteService;
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
}
