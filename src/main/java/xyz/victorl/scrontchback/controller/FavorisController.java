package xyz.victorl.scrontchback.controller;

import xyz.victorl.scrontchback.model.dto.FavorisDto;
import xyz.victorl.scrontchback.service.FavorisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavorisController {
    @Autowired
    private FavorisService favorisService;

    @GetMapping
    public List<FavorisDto> getAllFavorites() {
        return favorisService.getAllFavorites();
    }

    @GetMapping("/{idRecette}/{idUtilisateur}")
    public FavorisDto getFavorisById(
            @PathVariable Integer idRecette,
            @PathVariable Integer idUtilisateur) {
        return favorisService.getFavorisById(idRecette, idUtilisateur);
    }
    @PostMapping
    public FavorisDto createFavoris(@RequestBody FavorisDto favorisDto){
        return favorisService.createFavoris(favorisDto);
    }
    @PutMapping("/{idRecette}/{idUtilisateur}")
    public FavorisDto updateFavoris(
            @PathVariable Integer idRecette,
            @PathVariable Integer idUtilisateur,
            @RequestBody FavorisDto favorisDto) {
        return favorisService.updateFavoris(idRecette, idUtilisateur, favorisDto);
    }

    @DeleteMapping("/{idRecette}/{idUtilisateur}")
    public void deleteFavoris(
            @PathVariable Integer idRecette,
            @PathVariable Integer idUtilisateur) {
        favorisService.deleteFavoris(idRecette, idUtilisateur);
    }
}

