package com.gestionrecettes.back.controller;

import com.gestionrecettes.back.model.dto.CategorieIngredientDto;
import com.gestionrecettes.back.service.CategorieIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories-ingredients")
public class CategorieIngredientController {

    @Autowired
    private CategorieIngredientService categorieIngredientService;

    @GetMapping
    public ResponseEntity<List<CategorieIngredientDto>> getAllCategories() {
        List<CategorieIngredientDto> categories = categorieIngredientService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategorieIngredientDto> getCategorieById(@PathVariable Integer id) {
        CategorieIngredientDto category = categorieIngredientService.getCategorieById(id);
        return category != null ? new ResponseEntity<>(category, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<CategorieIngredientDto> createCategorie(@RequestBody CategorieIngredientDto categorieDto) {
        CategorieIngredientDto createdCategorie = categorieIngredientService.createCategorie(categorieDto);
        return new ResponseEntity<>(createdCategorie, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategorieIngredientDto> updateCategorie(@PathVariable Integer id, @RequestBody CategorieIngredientDto categorieDto) {
        CategorieIngredientDto updatedCategorie = categorieIngredientService.updateCategorie(id, categorieDto);
        return updatedCategorie != null ? new ResponseEntity<>(updatedCategorie, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategorie(@PathVariable Integer id) {
        categorieIngredientService.deleteCategorie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
