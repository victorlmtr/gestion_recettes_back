package xyz.victorl.scrontchback.controller;

import xyz.victorl.scrontchback.model.dto.IngredientDetailsDto;
import xyz.victorl.scrontchback.service.IngredientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredient-details")
public class IngredientDetailsController {

    private final IngredientDetailsService ingredientDetailsService;

    @Autowired
    public IngredientDetailsController(IngredientDetailsService ingredientDetailsService) {
        this.ingredientDetailsService = ingredientDetailsService;
    }

    @GetMapping
    public ResponseEntity<List<IngredientDetailsDto>> getAllDetails() {
        List<IngredientDetailsDto> details = ingredientDetailsService.getAllDetails();
        return ResponseEntity.ok(details);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientDetailsDto> getDetailById(@PathVariable Integer id) {
        IngredientDetailsDto detail = ingredientDetailsService.getDetailsById(id);
        if (detail == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detail);
    }

    @PostMapping
    public ResponseEntity<IngredientDetailsDto> createDetail(@RequestBody IngredientDetailsDto ingredientDetailsDto) {
        IngredientDetailsDto createdDetail = ingredientDetailsService.createDetail(ingredientDetailsDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDetail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngredientDetailsDto> updateDetail(@PathVariable Integer id, @RequestBody IngredientDetailsDto ingredientDetailsDto) {
        IngredientDetailsDto updatedDetail = ingredientDetailsService.updateDetail(id, ingredientDetailsDto);
        if (updatedDetail == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedDetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetail(@PathVariable Integer id) {
        ingredientDetailsService.deleteDetail(id);
        return ResponseEntity.noContent().build();
    }
}
