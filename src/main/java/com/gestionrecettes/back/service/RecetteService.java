package com.gestionrecettes.back.service;

import com.gestionrecettes.back.model.dto.IngredientRecetteDto;
import com.gestionrecettes.back.model.dto.RecetteDto;
import com.gestionrecettes.back.model.entity.DietsList;
import com.gestionrecettes.back.model.entity.RecipeDiet;
import com.gestionrecettes.back.model.entity.Recette;
import com.gestionrecettes.back.model.entity.RegimeRecette;
import com.gestionrecettes.back.model.mapper.IngredientRecetteMapper;
import com.gestionrecettes.back.model.mapper.RecetteMapper;
import com.gestionrecettes.back.repository.DietsListRepository;
import com.gestionrecettes.back.repository.RecetteRepository;
import com.gestionrecettes.back.repository.RecipeDietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecetteService {
    private final RecetteRepository recetteRepository;
    private final RecetteMapper recetteMapper;
    private final IngredientRecetteMapper ingredientRecetteMapper;
    private final RecipeDietRepository recipeDietRepository;
    private final DietsListRepository dietsListRepository;

    @Autowired
    public RecetteService(RecetteRepository recetteRepository, RecetteMapper recetteMapper, IngredientRecetteMapper ingredientRecetteMapper, RecipeDietRepository recipeDietRepository, DietsListRepository dietsListRepository) {
        this.recetteRepository = recetteRepository;
        this.recetteMapper = recetteMapper;
        this.ingredientRecetteMapper = ingredientRecetteMapper;
        this.recipeDietRepository = recipeDietRepository;
        this.dietsListRepository = dietsListRepository;
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

    public List<RecetteDto> getFiveMostRecentRecipes() {
        List<Recette> recentRecipes = recetteRepository.findAll(
                PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "datePublicationRecette"))
        ).getContent();
        return recetteMapper.toDtoList(recentRecipes);
    }

    public List<RecetteDto> getRecipesByCountry(Integer idPays) {
        List<Recette> recettes = recetteRepository.findByIdPays_Id(idPays);
        return recetteMapper.toDtoList(recettes);
    }

    public List<RecetteDto> getRecipesByContinent(Integer idContinent) {
        List<Recette> recettes = recetteRepository.findByContinentId(idContinent);
        return recetteMapper.toDtoList(recettes);
    }

    public List<RecetteDto> getRecipesByType(Integer idTypeRecette) {
        List<Recette> recettes = recetteRepository.findByIdTypeRecette_Id(idTypeRecette);
        return recetteMapper.toDtoList(recettes);
    }

    public List<RecetteDto> getRecipesByRegime(Integer idRegimeRecette) {
        List<Recette> recettes = recetteRepository.findByRegimeRecettes(idRegimeRecette);
        return recetteMapper.toDtoList(recettes);
    }

    public List<RecetteDto> getRecipesByFilters(Integer idTypeRecette, Integer idRegimeRecette, Integer difficulteRecette, Integer idPays, Integer idContinent) {
        List<Recette> recettes = recetteRepository.findByFilters(idTypeRecette, idRegimeRecette, difficulteRecette, idPays, idContinent);
        return recetteMapper.toDtoList(recettes);
    }
}