package com.gestionrecettes.back.service;

import com.gestionrecettes.back.model.dto.*;
import com.gestionrecettes.back.model.entity.RecipeDiet;
import com.gestionrecettes.back.model.entity.RecipeDietId;
import com.gestionrecettes.back.model.mapper.RecipeDietMapper;
import com.gestionrecettes.back.model.mapper.RegimeRecetteMapper;
import com.gestionrecettes.back.model.mapper.EtapeMapper;
import com.gestionrecettes.back.repository.RecipeDietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeDietService {

    private final RecipeDietRepository recipeDietRepository;
    private final RecipeDietMapper recipeDietMapper;
    private final RegimeRecetteMapper regimeRecetteMapper;
    private final EtapeMapper etapeMapper;

    @Autowired
    public RecipeDietService(RecipeDietRepository recipeDietRepository, RecipeDietMapper recipeDietMapper, RegimeRecetteMapper regimeRecetteMapper, EtapeMapper etapeMapper) {
        this.recipeDietRepository = recipeDietRepository;
        this.recipeDietMapper = recipeDietMapper;
        this.regimeRecetteMapper = regimeRecetteMapper;
        this.etapeMapper = etapeMapper;
    }

    public List<RecipeDietDto> getAllRecipeDiets() {
        List<RecipeDiet> recipeDiets = recipeDietRepository.findAll();
        return recipeDiets.stream()
                .map(recipeDietMapper::toDto)
                .collect(Collectors.toList());
    }

    public RecipeDietDto getRecipeDietById(Integer idRegimeRecette, Integer idRecette) {
        RecipeDietId id = new RecipeDietId();
        id.setIdRegimeRecette(idRegimeRecette);
        id.setIdRecette(idRecette);
        RecipeDiet recipeDiet = recipeDietRepository.findById(id).orElseThrow();
        return recipeDietMapper.toDto(recipeDiet);
    }

    public RecipeDietDto createRecipeDiet(RecipeDietDto recipeDietDto) {
        RecipeDiet recipeDiet = recipeDietMapper.toEntity(recipeDietDto);
        RecipeDiet savedRecipeDiet = recipeDietRepository.save(recipeDiet);
        return recipeDietMapper.toDto(savedRecipeDiet);
    }

    public RecipeDietDto updateRecipeDiet(Integer idRegimeRecette, Integer idRecette) {
        RecipeDietId id = new RecipeDietId();
        id.setIdRegimeRecette(idRegimeRecette);
        id.setIdRecette(idRecette);
        RecipeDiet recipeDiet = recipeDietRepository.findById(id).orElseThrow();
        recipeDiet = recipeDietRepository.save(recipeDiet);
        return recipeDietMapper.toDto(recipeDiet);
    }

    public void deleteRecipeDiet(Integer idRegimeRecette, Integer idRecette) {
        RecipeDietId id = new RecipeDietId();
        id.setIdRegimeRecette(idRegimeRecette);
        id.setIdRecette(idRecette);
        recipeDietRepository.deleteById(id);
    }
}