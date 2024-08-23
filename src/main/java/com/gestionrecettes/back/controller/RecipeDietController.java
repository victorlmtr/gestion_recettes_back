package com.gestionrecettes.back.controller;

import com.gestionrecettes.back.model.dto.RecipeDietDto;
import com.gestionrecettes.back.service.RecipeDietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe-diets")
public class RecipeDietController {
    @Autowired
    private RecipeDietService recipeDietService;

    @GetMapping
    public ResponseEntity<List<RecipeDietDto>> getAllRecipeDiets() {
        List<RecipeDietDto> recipeDietDtos = recipeDietService.getAllRecipeDiets();
        if (recipeDietDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(recipeDietDtos, HttpStatus.OK);
    }


    @GetMapping("/{idRegimeRecette}/{idRecette}")
    public RecipeDietDto getRecipeDietById(
            @PathVariable Integer idRegimeRecette,
            @PathVariable Integer idRecette) {
        return recipeDietService.getRecipeDietById(idRegimeRecette, idRecette);
    }
    @PostMapping
    public RecipeDietDto createRecipeDiet(@RequestBody RecipeDietDto recipeDietDto){
        return recipeDietService.createRecipeDiet(recipeDietDto);
    }
    @PutMapping("/{idRegimeRecette}/{idRecette}")
    public RecipeDietDto updateRecipeDiet(
            @PathVariable Integer idRegimeRecette,
            @PathVariable Integer idRecette) {
        return recipeDietService.updateRecipeDiet(idRegimeRecette, idRecette);
    }

    @DeleteMapping("/{idRegimeRecette}/{idRecette}")
    public void deleteRecipeDiet(
            @PathVariable Integer idRegimeRecette,
            @PathVariable Integer idRecette) {
        recipeDietService.deleteRecipeDiet(idRegimeRecette, idRecette);
    }
}

