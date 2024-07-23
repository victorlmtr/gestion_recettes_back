package com.gestionrecettes.back.service;

import com.gestionrecettes.back.model.dto.IngredientDto;
import com.gestionrecettes.back.model.entity.Ingredient;
import com.gestionrecettes.back.model.mapper.IngredientMapper;
import com.gestionrecettes.back.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository, IngredientMapper ingredientMapper) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientMapper = ingredientMapper;
    }

    public List<IngredientDto> getAllIngredients() {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        return ingredientMapper.toDtoList(ingredients);
    }

    public IngredientDto getIngredientById(Integer id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        return ingredient.map(ingredientMapper::toDto).orElse(null);
    }

    public IngredientDto createIngredient(IngredientDto ingredientDto) {
        Ingredient ingredient = ingredientMapper.toEntity(ingredientDto);
        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        return ingredientMapper.toDto(savedIngredient);
    }

    public IngredientDto updateIngredient(Integer id, IngredientDto ingredientDto) {
        if (!ingredientRepository.existsById(id)) {
            return null;
        }
        Ingredient ingredient = ingredientMapper.toEntity(ingredientDto);
        ingredient.setId(id);
        Ingredient updatedIngredient = ingredientRepository.save(ingredient);
        return ingredientMapper.toDto(updatedIngredient);
    }

    public void deleteIngredient(Integer id) {
        if (ingredientRepository.existsById(id)) {
            ingredientRepository.deleteById(id);
        }
    }
}
