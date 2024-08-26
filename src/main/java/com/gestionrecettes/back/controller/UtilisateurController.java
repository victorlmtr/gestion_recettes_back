package com.gestionrecettes.back.controller;

import com.gestionrecettes.back.model.dto.IngredientDto;
import com.gestionrecettes.back.model.dto.UtilisateurDto;
import com.gestionrecettes.back.service.StockIngredientService;
import com.gestionrecettes.back.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;
    private final StockIngredientService stockIngredientService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService, StockIngredientService stockIngredientService) {
        this.utilisateurService = utilisateurService;
        this.stockIngredientService = stockIngredientService;
    }

    @GetMapping
    public ResponseEntity<List<UtilisateurDto>> getAllUtilisateurs() {
        List<UtilisateurDto> utilisateurs = utilisateurService.getAllUtilisateurs();
        return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDto> getUtilisateurById(@PathVariable Long id) {
        UtilisateurDto utilisateur = utilisateurService.getUtilisateurById(id);
        return utilisateur != null ? new ResponseEntity<>(utilisateur, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{id}/username")
    public ResponseEntity<String> getUsernameById(@PathVariable Long id) {
        String username = utilisateurService.getUsernameById(id);
        return username != null ? new ResponseEntity<>(username, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/username/{nomUtilisateur}")
    public ResponseEntity<UtilisateurDto> getUtilisateurByNomUtilisateur(@PathVariable String nomUtilisateur) {
        UtilisateurDto utilisateur = utilisateurService.getUtilisateurByNomUtilisateur(nomUtilisateur);
        return utilisateur != null ? new ResponseEntity<>(utilisateur, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<UtilisateurDto> createUtilisateur(@RequestBody UtilisateurDto utilisateurDto) {
        UtilisateurDto createdUtilisateur = utilisateurService.createUtilisateur(utilisateurDto);
        return new ResponseEntity<>(createdUtilisateur, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UtilisateurDto> updateUtilisateur(@PathVariable Long id, @RequestBody UtilisateurDto utilisateurDto) {
        UtilisateurDto updatedUtilisateur = utilisateurService.updateUtilisateur(id, utilisateurDto);
        return updatedUtilisateur != null ? new ResponseEntity<>(updatedUtilisateur, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {
        utilisateurService.deleteUtilisateur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{idUtilisateur}/ingredients")
    public ResponseEntity<List<IngredientDto>> getAllIngredientsForUser(@PathVariable Integer idUtilisateur) {
        List<IngredientDto> ingredients = stockIngredientService.getIngredientsForUser(idUtilisateur);
        return new ResponseEntity<>(ingredients, HttpStatus.OK);
    }
}
