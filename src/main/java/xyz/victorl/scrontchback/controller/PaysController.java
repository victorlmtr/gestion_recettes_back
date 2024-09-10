package xyz.victorl.scrontchback.controller;

import xyz.victorl.scrontchback.model.dto.PaysDto;
import xyz.victorl.scrontchback.service.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class PaysController {

    @Autowired
    private PaysService paysService;

    @GetMapping
    public ResponseEntity<List<PaysDto>> getAllCountries() {
        List<PaysDto> countries = paysService.getAllCountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaysDto> getCountryById(@PathVariable Integer id) {
        PaysDto pays = paysService.getCountryById(id);
        return pays != null ? new ResponseEntity<>(pays, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<PaysDto> createCountry(@RequestBody PaysDto paysDto) {
        PaysDto createdCountry = paysService.createCountry(paysDto);
        return new ResponseEntity<>(createdCountry, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaysDto> updateCountry(@PathVariable Integer id, @RequestBody PaysDto paysDto) {
        PaysDto updatedCountry = paysService.updateCountry(id, paysDto);
        return updatedCountry != null ? new ResponseEntity<>(updatedCountry, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Integer id) {
        paysService.deleteCountry(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
