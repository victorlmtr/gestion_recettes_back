package xyz.victorl.scrontchback.controller;

import xyz.victorl.scrontchback.model.dto.ListeCoursesDto;
import xyz.victorl.scrontchback.model.dto.NonConsommableDto;
import xyz.victorl.scrontchback.service.ListeCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grocery-lists")
public class ListeCoursesController {

    @Autowired
    private ListeCoursesService listeCoursesService;

    @GetMapping
    public List<ListeCoursesDto> getAllListesCourses() {
        return listeCoursesService.getAllListesCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListeCoursesDto> getListeCoursesById(@PathVariable Integer id) {
        ListeCoursesDto listeCourses = listeCoursesService.getListeCoursesById(id);
        return listeCourses != null ? new ResponseEntity<>(listeCourses, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<ListeCoursesDto> createListeCourses(@RequestBody ListeCoursesDto listeCoursesDto) {
        ListeCoursesDto createdListeCourses = listeCoursesService.createListeCourses(listeCoursesDto);
        return new ResponseEntity<>(createdListeCourses, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListeCoursesDto> updateListeCourses(@PathVariable Integer id, @RequestBody ListeCoursesDto listeCoursesDto) {
        ListeCoursesDto updatedListeCourses = listeCoursesService.updateListeCourses(id, listeCoursesDto);
        return updatedListeCourses != null ? new ResponseEntity<>(updatedListeCourses, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListeCourses(@PathVariable Integer id) {
        listeCoursesService.deleteListeCourses(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}/add-non-food-item")
    public ResponseEntity<ListeCoursesDto> addNonFoodItemToListeCourses(
            @PathVariable Integer id, @RequestBody NonConsommableDto nonConsommableDto) {
        ListeCoursesDto updatedListeCourses = listeCoursesService.addNonFoodItemToListeCourses(id, nonConsommableDto);
        return updatedListeCourses != null ? new ResponseEntity<>(updatedListeCourses, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
