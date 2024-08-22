package com.gestionrecettes.back.service;

import com.gestionrecettes.back.model.dto.IngredientDto;
import com.gestionrecettes.back.model.dto.ListeCoursesDto;
import com.gestionrecettes.back.model.dto.NonConsommableDto;
import com.gestionrecettes.back.model.entity.ListeCourses;
import com.gestionrecettes.back.model.entity.NonConsommable;
import com.gestionrecettes.back.model.entity.NonFoodList;
import com.gestionrecettes.back.model.entity.NonFoodListId;
import com.gestionrecettes.back.model.mapper.ListeCoursesMapper;
import com.gestionrecettes.back.model.mapper.NonConsommableMapper;
import com.gestionrecettes.back.repository.ListeCoursesRepository;
import com.gestionrecettes.back.repository.NonConsommableRepository;
import com.gestionrecettes.back.repository.NonFoodListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListeCoursesService {
    private final ListeCoursesRepository listeCoursesRepository;
    private final NonConsommableRepository nonConsommableRepository;
    private final ListeCoursesMapper listeCoursesMapper;
    private final NonConsommableMapper nonConsommableMapper;
    private final NonFoodListRepository nonFoodListRepository;

    @Autowired
    public ListeCoursesService(
            ListeCoursesRepository listeCoursesRepository, NonConsommableRepository nonConsommableRepository,
            ListeCoursesMapper listeCoursesMapper, NonConsommableMapper nonConsommableMapper, NonFoodListRepository nonFoodListRepository) {
        this.listeCoursesRepository = listeCoursesRepository;
        this.nonConsommableRepository = nonConsommableRepository;
        this.listeCoursesMapper = listeCoursesMapper;
        this.nonConsommableMapper = nonConsommableMapper;
        this.nonFoodListRepository = nonFoodListRepository;
    }

    public List<ListeCoursesDto> getAllListesCourses() {
        List<ListeCourses> listesCourses = listeCoursesRepository.findAll();
        return listeCoursesMapper.toDtoList(listesCourses);
    }

    public ListeCoursesDto getListeCoursesById(Integer id) {
        ListeCourses listeCourses = listeCoursesRepository.findById(id).orElse(null);
        return listeCourses != null ? listeCoursesMapper.toDto(listeCourses) : null;
    }

    public ListeCoursesDto createListeCourses(ListeCoursesDto listeCoursesDto) {
        ListeCourses listeCourses = listeCoursesMapper.toEntity(listeCoursesDto);
        ListeCourses savedListeCourses = listeCoursesRepository.save(listeCourses);
        return listeCoursesMapper.toDto(savedListeCourses);
    }

    public ListeCoursesDto updateListeCourses(Integer id, ListeCoursesDto listeCoursesDto) {
        if (!listeCoursesRepository.existsById(id)) {
            return null;
        }
        ListeCourses listeCourses = listeCoursesMapper.toEntity(listeCoursesDto);
        listeCourses.setId(id);
        ListeCourses updatedListeCourses = listeCoursesRepository.save(listeCourses);
        return listeCoursesMapper.toDto(updatedListeCourses);
    }

    public void deleteListeCourses(Integer id) { listeCoursesRepository.deleteById(id);}

    // Methods for adding/removing ingredients and non-food items
    public ListeCoursesDto addIngredientToListeCourses(Integer id, IngredientDto ingredientDto) {
        // Logic for adding ingredient to the grocery list
        return null;
    }

    public ListeCoursesDto removeIngredientFromListeCourses(Integer id, Integer id_ingredient) {
        // Logic for removing ingredient from the grocery list
        return null;
    }

    public ListeCoursesDto addNonFoodItemToListeCourses(Integer id, NonConsommableDto nonConsommableDto) {
        ListeCourses listeCourses = listeCoursesRepository.findById(id).orElse(null);
        if (listeCourses == null) {
            return null; // Return null if the list is not found
        }

        // Convert the NonConsommableDto to entity and save if it doesn't exist
        NonConsommable nonConsommable = nonConsommableMapper.toEntity(nonConsommableDto);
        if (!nonConsommableRepository.existsById(nonConsommable.getId())) {
            nonConsommableRepository.save(nonConsommable);
        }

        // Create and save the association between the grocery list and the non-consommable item
        NonFoodList nonFoodList = new NonFoodList();
        NonFoodListId nonFoodListId = new NonFoodListId();
        nonFoodListId.setIdListeCourses(listeCourses.getId());
        nonFoodListId.setIdNonConsommable(nonConsommable.getId());
        nonFoodList.setId(nonFoodListId);
        nonFoodList.setIdListeCourses(listeCourses);
        nonFoodList.setIdNonConsommable(nonConsommable);

        // Assuming there's a repository for the NonFoodList entity to manage the association
        nonFoodListRepository.save(nonFoodList);

        // Return the updated DTO
        return listeCoursesMapper.toDto(listeCourses);
    }

    public ListeCoursesDto removeNonFoodItemFromListeCourses(Integer id, Integer id_nonConsommable) {
        // Logic for removing non-food item from the grocery list
        return null;
    }
}
