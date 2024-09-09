package xyz.victorl.scrontchback.controller;

import xyz.victorl.scrontchback.model.dto.TypeRecetteDto;
import xyz.victorl.scrontchback.service.TypeRecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
public class TypeRecetteController {

    private final TypeRecetteService typeRecetteService;

    @Autowired
    public TypeRecetteController(TypeRecetteService typeRecetteService) {
        this.typeRecetteService = typeRecetteService;
    }

    @GetMapping
    public ResponseEntity<List<TypeRecetteDto>> getAllTypes() {
        List<TypeRecetteDto> types = typeRecetteService.getAllTypes();
        return ResponseEntity.ok(types);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeRecetteDto> getTypeById(@PathVariable Integer id) {
        TypeRecetteDto type = typeRecetteService.getTypeById(id);
        if (type == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(type);
    }

    @GetMapping("/{id}/icon")
    public ResponseEntity<byte[]> getIcon(@PathVariable Integer id) {
        TypeRecetteDto typeRecetteDto = typeRecetteService.getTypeById(id);
        if (typeRecetteDto == null || typeRecetteDto.getIconeTypeRecette() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(typeRecetteDto.getIconeTypeRecette(), headers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TypeRecetteDto> createType(@RequestBody TypeRecetteDto typeRecetteDto) {
        TypeRecetteDto createdType = typeRecetteService.createType(typeRecetteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeRecetteDto> updateType(@PathVariable Integer id, @RequestBody TypeRecetteDto typeRecetteDto) {
        TypeRecetteDto updatedType = typeRecetteService.updateType(id, typeRecetteDto);
        if (updatedType == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable Integer id) {
        typeRecetteService.deleteType(id);
        return ResponseEntity.noContent().build();
    }
}
