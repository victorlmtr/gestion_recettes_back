package com.gestionrecettes.back.service;

import com.gestionrecettes.back.model.dto.RecetteDto;
import com.gestionrecettes.back.model.entity.Recette;
import com.gestionrecettes.back.model.mapper.RecetteMapper;
import com.gestionrecettes.back.repository.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecetteService {
    private final RecetteRepository recetteRepository;
    private final RecetteMapper recetteMapper;

    @Autowired
    public RecetteService(RecetteRepository recetteRepository, RecetteMapper recetteMapper) {
        this.recetteRepository = recetteRepository;
        this.recetteMapper = recetteMapper;
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
}