package com.gestionrecettes.back.controller;

import com.gestionrecettes.back.model.dto.UniteMesureDto;
import com.gestionrecettes.back.service.UniteMesureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/units")
public class UniteMesureController {

    @Autowired
    private UniteMesureService uniteMesureService;

    @GetMapping
    public ResponseEntity<List<UniteMesureDto>> getAllUnitesMesure() {
        List<UniteMesureDto> unitesMesure = uniteMesureService.getAllUnitesMesure();
        return new ResponseEntity<>(unitesMesure, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniteMesureDto> getUniteMesureById(@PathVariable Integer id) {
        UniteMesureDto uniteMesure = uniteMesureService.getUniteMesureById(id);
        return uniteMesure != null ? new ResponseEntity<>(uniteMesure, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<UniteMesureDto> createUniteMesure(@RequestBody UniteMesureDto uniteMesureDto) {
        UniteMesureDto createdUniteMesure = uniteMesureService.createUniteMesure(uniteMesureDto);
        return new ResponseEntity<>(createdUniteMesure, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UniteMesureDto> updateUniteMesure(@PathVariable Integer id, @RequestBody UniteMesureDto uniteMesureDto) {
        UniteMesureDto updatedUniteMesure = uniteMesureService.updateUniteMesure(id, uniteMesureDto);
        return updatedUniteMesure != null ? new ResponseEntity<>(updatedUniteMesure, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniteMesure(@PathVariable Integer id) {
        uniteMesureService.deleteUniteMesure(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

