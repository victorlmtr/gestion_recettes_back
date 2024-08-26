package com.gestionrecettes.back.service;

import com.gestionrecettes.back.model.dto.IngredientDto;
import com.gestionrecettes.back.model.dto.IngredientRecetteDto;
import com.gestionrecettes.back.model.dto.RecetteDto;
import com.gestionrecettes.back.model.entity.Etape;
import com.gestionrecettes.back.model.entity.IngredientRecette;
import com.gestionrecettes.back.model.entity.Recette;
import com.gestionrecettes.back.model.mapper.IngredientRecetteMapper;
import com.gestionrecettes.back.model.mapper.RecetteMapper;
import com.gestionrecettes.back.repository.RecetteRepository;
import com.gestionrecettes.back.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RecetteService {
    private final RecetteRepository recetteRepository;
    private final RecetteMapper recetteMapper;
    private final IngredientRecetteMapper ingredientRecetteMapper;
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public RecetteService(RecetteRepository recetteRepository, RecetteMapper recetteMapper, IngredientRecetteMapper ingredientRecetteMapper, UtilisateurRepository utilisateurRepository) {
        this.recetteRepository = recetteRepository;
        this.recetteMapper = recetteMapper;
        this.ingredientRecetteMapper = ingredientRecetteMapper;
        this.utilisateurRepository = utilisateurRepository;
    }

    @Transactional
    public RecetteDto createRecette(RecetteDto recetteDto) {
        Recette recette = recetteMapper.toEntity(recetteDto);
        recette = recetteRepository.save(recette);
        return recetteMapper.toDto(recette);
    }

    @Transactional
    public RecetteDto updateRecette(RecetteDto recetteDto) {
        Recette recette = recetteRepository.findById(recetteDto.getId()).orElseThrow();
        recetteMapper.partialUpdate(recetteDto, recette);
        recette = recetteRepository.save(recette);
        return recetteMapper.toDto(recette);
    }

    @Transactional
    public void deleteRecette(Integer id) {
        recetteRepository.deleteById(id);
    }

    public List<RecetteDto> getAllRecettes() {
        List<Recette> recettes = recetteRepository.findAll();
        return recetteMapper.toDtoList(recettes);
    }

    public RecetteDto getRecetteById(Integer id) {
        Recette recette = recetteRepository.findById(id).orElseThrow();
        return recetteMapper.toDto(recette);
    }

    @Transactional
    public List<IngredientRecetteDto> getIngredientsForAllSteps(Integer recetteId) {
        Recette recette = recetteRepository.findById(recetteId)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
        return recette.getEtapes().stream()
                .flatMap(etape -> etape.getIngredientRecettes().stream())
                .map(ingredientRecetteMapper::toDto)
                .toList();
    }



}