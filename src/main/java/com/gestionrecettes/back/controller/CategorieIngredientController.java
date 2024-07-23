package com.gestionrecettes.back.controller;

import com.gestionrecettes.back.model.dto.CategorieIngredientDto;
import com.gestionrecettes.back.service.CategorieIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories-ingredients")
public class CategorieIngredientController {

    private final CategorieIngredientService categorieIngredientService;

    @Autowired
    public CategorieIngredientController(CategorieIngredientService categorieIngredientService) {
        this.categorieIngredientService = categorieIngredientService;
    }

    @GetMapping
    public ResponseEntity<List<CategorieIngredientDto>> getAllCategories() {
        List<CategorieIngredientDto> categories = categorieIngredientService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategorieIngredientDto> getCategorieById(@PathVariable Integer id) {
        CategorieIngredientDto category = categorieIngredientService.getCategorieById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}/icon")
    public ResponseEntity<byte[]> getIcon(@PathVariable Integer id) {
        CategorieIngredientDto categorieDto = categorieIngredientService.getCategorieById(id);
        if (categorieDto == null || categorieDto.getIconeCategorie() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(categorieDto.getIconeCategorie(), headers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategorieIngredientDto> createCategorie(@RequestBody CategorieIngredientDto categorieDto) {
        CategorieIngredientDto createdCategorie = categorieIngredientService.createCategorie(categorieDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategorie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategorieIngredientDto> updateCategorie(@PathVariable Integer id, @RequestBody CategorieIngredientDto categorieDto) {
        CategorieIngredientDto updatedCategorie = categorieIngredientService.updateCategorie(id, categorieDto);
        if (updatedCategorie != null) {
            return ResponseEntity.ok(updatedCategorie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategorie(@PathVariable Integer id) {
        categorieIngredientService.deleteCategorie(id);
        return ResponseEntity.noContent().build();
    }
}
