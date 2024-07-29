package com.gestionrecettes.back.controller;

import com.gestionrecettes.back.model.dto.EtapeDto;
import com.gestionrecettes.back.service.EtapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/steps")
public class EtapeController {

    @Autowired
    private EtapeService etapeService;

    @GetMapping
    public ResponseEntity<List<EtapeDto>> getAllEtapes() {
        List<EtapeDto> etapes = etapeService.getAllEtapes();
        return new ResponseEntity<>(etapes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtapeDto> getEtapeById(@PathVariable Integer id) {
        EtapeDto etape = etapeService.getEtapeById(id);
        return etape != null ? new ResponseEntity<>(etape, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<EtapeDto> createEtape(@RequestBody EtapeDto etapeDto) {
        EtapeDto createdEtape = etapeService.createEtape(etapeDto);
        return new ResponseEntity<>(createdEtape, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtapeDto> updateEtape(@PathVariable Integer id, @RequestBody EtapeDto etapeDto) {
        EtapeDto updatedEtape = etapeService.updateEtape(id, etapeDto);
        return updatedEtape != null ? new ResponseEntity<>(updatedEtape, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtape(@PathVariable Integer id) {
        etapeService.deleteEtape(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

