package com.gestionrecettes.back.controller;

import com.gestionrecettes.back.model.dto.StockIngredientDto;
import com.gestionrecettes.back.service.StockIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stored-ingredients")
public class StockIngredientController {
    @Autowired
    private StockIngredientService stockIngredientService;

    @GetMapping
    public List<StockIngredientDto> getAllStocksIngredient() {
        return stockIngredientService.getAllStocksIngredient();
    }

    @GetMapping("/{idIngredient}/{idUtilisateur}")
    public StockIngredientDto getStockIngredientById(
            @PathVariable Integer idIngredient,
            @PathVariable Integer idUtilisateur) {
        return stockIngredientService.getStockIngredientById(idIngredient, idUtilisateur);
    }
    @PostMapping
    public StockIngredientDto createStockIngredient(@RequestBody StockIngredientDto stockIngredientDto){
        return stockIngredientService.createStockIngredient(stockIngredientDto);
    }
    @PutMapping("/{idIngredient}/{idUtilisateur}")
    public StockIngredientDto updateStockIngredient(
            @PathVariable Integer idIngredient,
            @PathVariable Integer idUtilisateur,
            @RequestBody StockIngredientDto stockIngredientDto) {
        return stockIngredientService.updateStockIngredient(idIngredient, idUtilisateur, stockIngredientDto);
    }

    @DeleteMapping("/{idIngredient}/{idUtilisateur}")
    public void deleteStockIngredient(
            @PathVariable Integer idIngredient,
            @PathVariable Integer idUtilisateur) {
        stockIngredientService.deleteStockIngredient(idIngredient, idUtilisateur);
    }
}

