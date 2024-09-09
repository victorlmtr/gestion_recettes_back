package xyz.victorl.scrontchback.controller;

import xyz.victorl.scrontchback.model.dto.ContinentDto;
import xyz.victorl.scrontchback.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/continents")
public class ContinentController {

    @Autowired
    private ContinentService continentService;

    @GetMapping
    public ResponseEntity<List<ContinentDto>> getAllContinents() {
        List<ContinentDto> continents = continentService.getAllContinents();
        return new ResponseEntity<>(continents, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContinentDto> getContinentById(@PathVariable Integer id) {
        ContinentDto continent = continentService.getContinentById(id);
        return continent != null ? new ResponseEntity<>(continent, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ContinentDto> createContinent(@RequestBody ContinentDto continentDto) {
        ContinentDto createdContinent = continentService.createContinent(continentDto);
        return new ResponseEntity<>(createdContinent, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContinentDto> updateContinent(@PathVariable Integer id, @RequestBody ContinentDto continentDto) {
        ContinentDto updatedContinent = continentService.updateContinent(id, continentDto);
        return updatedContinent != null ? new ResponseEntity<>(updatedContinent, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContinent(@PathVariable Integer id) {
        continentService.deleteContinent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
