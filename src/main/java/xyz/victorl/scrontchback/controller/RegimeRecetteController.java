package xyz.victorl.scrontchback.controller;

import xyz.victorl.scrontchback.model.dto.RegimeRecetteDto;
import xyz.victorl.scrontchback.service.RegimeRecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diets")
public class RegimeRecetteController {

    private final RegimeRecetteService regimeRecetteService;

    @Autowired
    public RegimeRecetteController(RegimeRecetteService regimeRecetteService) {
        this.regimeRecetteService = regimeRecetteService;
    }

    @GetMapping
    public ResponseEntity<List<RegimeRecetteDto>> getAllRegimes() {
        List<RegimeRecetteDto> regimes = regimeRecetteService.getAllRegimes();
        return ResponseEntity.ok(regimes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegimeRecetteDto> getRegimeById(@PathVariable Integer id) {
        RegimeRecetteDto regime = regimeRecetteService.getRegimeById(id);
        if (regime != null) {
            return ResponseEntity.ok(regime);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<RegimeRecetteDto> createRegime(@RequestBody RegimeRecetteDto regimeRecetteDto) {
        RegimeRecetteDto createdRegime = regimeRecetteService.createRegime(regimeRecetteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRegime);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegimeRecetteDto> updateRegime(@PathVariable Integer id, @RequestBody RegimeRecetteDto regimeRecetteDto) {
        RegimeRecetteDto updatedRegime = regimeRecetteService.updateRegime(id, regimeRecetteDto);
        if (updatedRegime != null) {
            return ResponseEntity.ok(updatedRegime);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegime(@PathVariable Integer id) {
        regimeRecetteService.deleteRegime(id);
        return ResponseEntity.noContent().build();
    }
}
