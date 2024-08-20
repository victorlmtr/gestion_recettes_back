package com.gestionrecettes.back.controller;

import com.gestionrecettes.back.model.dto.NonConsommableDto;
import com.gestionrecettes.back.service.NonConsommableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/non-food-items")
public class NonConsommableController {

    private final NonConsommableService nonConsommableService;

    @Autowired
    public NonConsommableController(NonConsommableService nonConsommableService) {
        this.nonConsommableService = nonConsommableService;
    }

    @GetMapping
    public ResponseEntity<List<NonConsommableDto>> getAllNonConsommables() {
        List<NonConsommableDto> nonConsommables = nonConsommableService.getAllNonConsommables();
        return new ResponseEntity<>(nonConsommables, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NonConsommableDto> getNonConsommableById(@PathVariable Integer id) {
        NonConsommableDto nonConsommable = nonConsommableService.getNonConsommableById(id);
        return nonConsommable != null ? new ResponseEntity<>(nonConsommable, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<NonConsommableDto> createNonConsommable(@RequestBody NonConsommableDto nonConsommableDto) {
        NonConsommableDto createdNonConsommable = nonConsommableService.createNonConsommable(nonConsommableDto);
        return new ResponseEntity<>(createdNonConsommable, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NonConsommableDto> updateNonConsommable(@PathVariable Integer id, @RequestBody NonConsommableDto nonConsommableDto) {
        NonConsommableDto updatedNonConsommable = nonConsommableService.updateNonConsommable(id, nonConsommableDto);
        return updatedNonConsommable != null ? new ResponseEntity<>(updatedNonConsommable, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNonConsommable(@PathVariable Integer id) {
        nonConsommableService.deleteNonConsommable(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
