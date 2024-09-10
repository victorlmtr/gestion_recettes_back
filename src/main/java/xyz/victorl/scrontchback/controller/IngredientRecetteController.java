package xyz.victorl.scrontchback.controller;

import xyz.victorl.scrontchback.model.dto.IngredientRecetteDto;
import xyz.victorl.scrontchback.service.IngredientRecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe-ingredients")
public class IngredientRecetteController {

    @Autowired
    private IngredientRecetteService ingredientRecetteService;

    @GetMapping
    public List<IngredientRecetteDto> getAllIngredientRecettes() {
        return ingredientRecetteService.getAllIngredientRecettes();
    }

    @GetMapping("/{idIngredient}/{idEtape}/{idUniteMesure}/{idIngredientDetails}")
    public IngredientRecetteDto getIngredientRecetteById(
            @PathVariable Integer idIngredient,
            @PathVariable Integer idEtape,
            @PathVariable Integer idUniteMesure,
            @PathVariable Integer idIngredientDetails) {
        return ingredientRecetteService.getIngredientRecetteById(idIngredient, idEtape, idUniteMesure, idIngredientDetails);
    }

    @PostMapping
    public IngredientRecetteDto createIngredientRecette(@RequestBody IngredientRecetteDto ingredientRecetteDto) {
        return ingredientRecetteService.createIngredientRecette(ingredientRecetteDto);
    }

    @PutMapping("/{idIngredient}/{idEtape}/{idUniteMesure}/{idIngredientDetails}")
    public IngredientRecetteDto updateIngredientRecette(
            @PathVariable Integer idIngredient,
            @PathVariable Integer idEtape,
            @PathVariable Integer idUniteMesure,
            @PathVariable Integer idIngredientDetails,
            @RequestBody IngredientRecetteDto ingredientRecetteDto) {
        return ingredientRecetteService.updateIngredientRecette(idIngredient, idEtape, idUniteMesure, idIngredientDetails, ingredientRecetteDto);
    }

    @DeleteMapping("/{idIngredient}/{idEtape}/{idUniteMesure}/{idIngredientDetails}")
    public void deleteIngredientRecette(
            @PathVariable Integer idIngredient,
            @PathVariable Integer idEtape,
            @PathVariable Integer idUniteMesure,
            @PathVariable Integer idIngredientDetails) {
        ingredientRecetteService.deleteIngredientRecette(idIngredient, idEtape, idUniteMesure, idIngredientDetails);
    }
}
