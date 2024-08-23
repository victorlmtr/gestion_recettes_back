package com.gestionrecettes.back.controller;

import com.gestionrecettes.back.model.dto.DietsListDto;
import com.gestionrecettes.back.service.DietsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diets-lists")
public class DietsListController {
    @Autowired
    private DietsListService dietsListService;

    @GetMapping
    public List<DietsListDto> getAllDietsLists() {
        return dietsListService.getAllDietsLists();
    }

    @GetMapping("/{idUtilisateur}/{idRegimeRecette}")
    public DietsListDto getDietsListById(
            @PathVariable Integer idUtilisateur,
            @PathVariable Integer idRegimeRecette) {
        return dietsListService.getDietsListById(idUtilisateur, idRegimeRecette);
    }
    @PostMapping
    public DietsListDto createDietsList(@RequestBody DietsListDto dietsListDto){
        return dietsListService.createDietsList(dietsListDto);
    }
    @PutMapping("/{idUtilisateur}/{idRegimeRecette}")
    public DietsListDto updateDietsList(
            @PathVariable Integer idUtilisateur,
            @PathVariable Integer idRegimeRecette,
            @RequestBody DietsListDto dietsListDto) {
        return dietsListService.updateDietsList(idUtilisateur, idRegimeRecette, dietsListDto);
    }

    @DeleteMapping("/{idUtilisateur}/{idRegimeRecette}")
    public void deleteDietsList(
            @PathVariable Integer idUtilisateur,
            @PathVariable Integer idRegimeRecette) {
        dietsListService.deleteDietsList(idUtilisateur, idRegimeRecette);
    }
}

