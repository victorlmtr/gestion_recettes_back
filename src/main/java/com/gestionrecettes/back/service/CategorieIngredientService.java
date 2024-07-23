package com.gestionrecettes.back.service;

import com.gestionrecettes.back.model.dto.CategorieIngredientDto;
import com.gestionrecettes.back.model.entity.CategorieIngredient;
import com.gestionrecettes.back.model.mapper.CategorieIngredientMapper;
import com.gestionrecettes.back.repository.CategorieIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieIngredientService {

    private final CategorieIngredientRepository categorieIngredientRepository;
    private final CategorieIngredientMapper categorieIngredientMapper;

    @Autowired
    public CategorieIngredientService(CategorieIngredientRepository categorieIngredientRepository, CategorieIngredientMapper categorieIngredientMapper) {
        this.categorieIngredientRepository = categorieIngredientRepository;
        this.categorieIngredientMapper = categorieIngredientMapper;
    }

    public List<CategorieIngredientDto> getAllCategories() {
        List<CategorieIngredient> categories = categorieIngredientRepository.findAll();
        return categorieIngredientMapper.toDtoList(categories);
    }

    public CategorieIngredientDto getCategorieById(Integer id) {
        Optional<CategorieIngredient> category = categorieIngredientRepository.findById(id);
        return category.map(categorieIngredientMapper::toDto).orElse(null);
    }

    public CategorieIngredientDto createCategorie(CategorieIngredientDto categorieDto) {
        CategorieIngredient categorie = categorieIngredientMapper.toEntity(categorieDto);
        CategorieIngredient savedCategorie = categorieIngredientRepository.save(categorie);
        return categorieIngredientMapper.toDto(savedCategorie);
    }

    public CategorieIngredientDto updateCategorie(Integer id, CategorieIngredientDto categorieDto) {
        if (!categorieIngredientRepository.existsById(id)) {
            return null;
        }
        CategorieIngredient categorie = categorieIngredientMapper.toEntity(categorieDto);
        categorie.setId(id);
        CategorieIngredient updatedCategorie = categorieIngredientRepository.save(categorie);
        return categorieIngredientMapper.toDto(updatedCategorie);
    }

    public void deleteCategorie(Integer id) {
        if (categorieIngredientRepository.existsById(id)) {
            categorieIngredientRepository.deleteById(id);
        }
    }
}
