package com.gestionrecettes.back.service;

import com.gestionrecettes.back.model.dto.*;
import com.gestionrecettes.back.model.entity.RecipeDiet;
import com.gestionrecettes.back.model.entity.RecipeDietId;
import com.gestionrecettes.back.model.mapper.RecipeDietMapper;
import com.gestionrecettes.back.model.mapper.RegimeRecetteMapperImpl;
import com.gestionrecettes.back.model.mapper.EtapeMapperImpl;
import com.gestionrecettes.back.repository.RecipeDietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeDietService {

    private final RecipeDietRepository recipeDietRepository;
    private final RecipeDietMapper recipeDietMapper;
    private final RegimeRecetteMapperImpl regimeRecetteMapper;
    private final EtapeMapperImpl etapeMapper;

    @Autowired
    public RecipeDietService(RecipeDietRepository recipeDietRepository, RecipeDietMapper recipeDietMapper, RegimeRecetteMapperImpl regimeRecetteMapper, EtapeMapperImpl etapeMapper) {
        this.recipeDietRepository = recipeDietRepository;
        this.recipeDietMapper = recipeDietMapper;
        this.regimeRecetteMapper = regimeRecetteMapper;
        this.etapeMapper = etapeMapper;
    }

    public List<RecipeDietDto> getAllRecipeDiets() {
        List<RecipeDiet> recipeDiets = recipeDietRepository.findAll();
        return recipeDiets.stream()
                .map(recipeDiet -> new RecipeDietDto(
                        new RegimeRecetteDto(
                                recipeDiet.getRegimeRecette().getId(),
                                recipeDiet.getRegimeRecette().getLibRegimeRecette(),
                                recipeDiet.getRegimeRecette().getIconeRegimeRecette()
                        ),
                        new RecetteDto(
                                recipeDiet.getRecette().getId(),
                                recipeDiet.getRecette().getLibRecette(),
                                recipeDiet.getRecette().getDescriptionRecette(),
                                recipeDiet.getRecette().getDifficulteRecette(),
                                recipeDiet.getRecette().getNombrePortion(),
                                recipeDiet.getRecette().getRemarqueRecette(),
                                recipeDiet.getRecette().getDatePublicationRecette(),
                                recipeDiet.getRecette().getImageRecette(),
                                new PaysDto(
                                        recipeDiet.getRecette().getIdPays().getId(),
                                        recipeDiet.getRecette().getIdPays().getLibPays(),
                                        new ContinentDto(
                                                recipeDiet.getRecette().getIdPays().getIdContinent().getId(),
                                                recipeDiet.getRecette().getIdPays().getIdContinent().getLibContinent()
                                        )
                                ),
                                new TypeRecetteDto(
                                        recipeDiet.getRecette().getIdTypeRecette().getId(),
                                        recipeDiet.getRecette().getIdTypeRecette().getLibTypeRecette(),
                                        recipeDiet.getRecette().getIdTypeRecette().getIconeTypeRecette()
                                ),
                                recipeDiet.getRecette().getRegimeRecettes().stream()
                                        .map(regimeRecetteMapper::toDto)
                                        .collect(Collectors.toSet()),
                                recipeDiet.getRecette().getEtapes().stream()
                                        .map(etapeMapper::toDto)
                                        .collect(Collectors.toSet())
                        )
                ))
                .toList();
    }

    public RecipeDietDto getRecipeDietById(Integer idRegimeRecette, Integer idRecette) {
        RecipeDietId id = new RecipeDietId();
        id.setIdRegimeRecette(idRegimeRecette);
        id.setIdRecette(idRecette);
        RecipeDiet recipeDiet = recipeDietRepository.findById(id).orElseThrow();
        return new RecipeDietDto(
                new RegimeRecetteDto(
                        recipeDiet.getRegimeRecette().getId(),
                        recipeDiet.getRegimeRecette().getLibRegimeRecette(),
                        recipeDiet.getRegimeRecette().getIconeRegimeRecette()
                ),
                new RecetteDto(
                        recipeDiet.getRecette().getId(),
                        recipeDiet.getRecette().getLibRecette(),
                        recipeDiet.getRecette().getDescriptionRecette(),
                        recipeDiet.getRecette().getDifficulteRecette(),
                        recipeDiet.getRecette().getNombrePortion(),
                        recipeDiet.getRecette().getRemarqueRecette(),
                        recipeDiet.getRecette().getDatePublicationRecette(),
                        recipeDiet.getRecette().getImageRecette(),
                        new PaysDto(
                                recipeDiet.getRecette().getIdPays().getId(),
                                recipeDiet.getRecette().getIdPays().getLibPays(),
                                new ContinentDto(
                                        recipeDiet.getRecette().getIdPays().getIdContinent().getId(),
                                        recipeDiet.getRecette().getIdPays().getIdContinent().getLibContinent()
                                )
                        ),
                        new TypeRecetteDto(
                                recipeDiet.getRecette().getIdTypeRecette().getId(),
                                recipeDiet.getRecette().getIdTypeRecette().getLibTypeRecette(),
                                recipeDiet.getRecette().getIdTypeRecette().getIconeTypeRecette()
                        ),
                        recipeDiet.getRecette().getRegimeRecettes().stream()
                                .map(regimeRecetteMapper::toDto)
                                .collect(Collectors.toSet()),
                        recipeDiet.getRecette().getEtapes().stream()
                                .map(etapeMapper::toDto)
                                .collect(Collectors.toSet())
                )
        );
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