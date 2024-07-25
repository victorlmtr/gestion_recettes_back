package com.gestionrecettes.back.service;

import com.gestionrecettes.back.model.dto.*;
import com.gestionrecettes.back.model.entity.IngredientDetails;
import com.gestionrecettes.back.model.entity.IngredientRecette;
import com.gestionrecettes.back.model.entity.IngredientRecetteId;
import com.gestionrecettes.back.model.mapper.IngredientRecetteMapper;
import com.gestionrecettes.back.repository.IngredientRecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngredientRecetteService {

    private final IngredientRecetteRepository ingredientRecetteRepository;
    private final IngredientRecetteMapper ingredientRecetteMapper;

    @Autowired
    public IngredientRecetteService(IngredientRecetteRepository ingredientRecetteRepository, IngredientRecetteMapper ingredientRecetteMapper) {
        this.ingredientRecetteRepository = ingredientRecetteRepository;
        this.ingredientRecetteMapper = ingredientRecetteMapper;
    }

    public List<IngredientRecetteDto> getAllIngredientRecettes() {
        List<IngredientRecette> ingredientRecettes = ingredientRecetteRepository.findAll();
        return ingredientRecettes.stream()
                .map(ingredientRecette -> new IngredientRecetteDto(

                        new IngredientDto(
                                ingredientRecette.getIngredient().getId(),
                                ingredientRecette.getIngredient().getLibIngredient(),
                                new CategorieIngredientDto(
                                        ingredientRecette.getIngredient().getCategorieIngredient().getId(),
                                        ingredientRecette.getIngredient().getCategorieIngredient().getLibCategorieIngredient(),
                                        ingredientRecette.getIngredient().getCategorieIngredient().getIconeCategorie()
                                )
                        ),
                        new EtapeDto(
                                ingredientRecette.getEtape().getId(),
                                ingredientRecette.getEtape().getDureeEtape(),
                                ingredientRecette.getEtape().getInstructionsEtape(),
                                ingredientRecette.getEtape().getImageEtape(),
                                new EtapeDto.TypeEtapeDto(
                                        ingredientRecette.getEtape().getIdTypeEtape().getId(),
                                        ingredientRecette.getEtape().getIdTypeEtape().getLibTypeEtape(),
                                        ingredientRecette.getEtape().getIdTypeEtape().getEtapes()
                                )
                        ),
                        new UniteMesureDto(
                                ingredientRecette.getUniteMesure().getId(),
                                ingredientRecette.getUniteMesure().getLibUniteMesure()),
                        new IngredientDetailsDto(
                                ingredientRecette.getIngredientDetails().getId(),
                                ingredientRecette.getIngredientDetails().getLibIngredientDetails()),
                        ingredientRecette.getEstFacultatif(),
                        ingredientRecette.getQuantite()

                ))
                .toList();
    }

    public IngredientRecetteDto getIngredientRecetteById(Integer idIngredient, Integer idEtape, Integer idUniteMesure, Integer idIngredientDetails) {
        IngredientRecetteId id = new IngredientRecetteId();
        id.setIdIngredient(idIngredient);
        id.setIdEtape(idEtape);
        id.setIdUniteMesure(idUniteMesure);
        id.setIdIngredientDetails(idIngredientDetails);
        IngredientRecette ingredientRecette = ingredientRecetteRepository.findById(id).orElseThrow();
        return new IngredientRecetteDto(
                new IngredientDto(
                        idIngredient,
                        ingredientRecette.getIngredient().getLibIngredient(),
                        new CategorieIngredientDto(
                                ingredientRecette.getIngredient().getCategorieIngredient().getId(),
                                ingredientRecette.getIngredient().getCategorieIngredient().getLibCategorieIngredient(),
                                ingredientRecette.getIngredient().getCategorieIngredient().getIconeCategorie()
                                )
                ),
                new EtapeDto(
                        idEtape,
                        ingredientRecette.getEtape().getDureeEtape(),
                        ingredientRecette.getEtape().getInstructionsEtape(),
                        ingredientRecette.getEtape().getImageEtape(),
                        new EtapeDto.TypeEtapeDto(
                                ingredientRecette.getEtape().getIdTypeEtape().getId(),
                                ingredientRecette.getEtape().getIdTypeEtape().getLibTypeEtape(),
                                ingredientRecette.getEtape().getIdTypeEtape().getEtapes()
                        )
                ),
                new UniteMesureDto(
                        idUniteMesure,
                        ingredientRecette.getUniteMesure().getLibUniteMesure()),
                new IngredientDetailsDto(
                        idIngredientDetails,
                        ingredientRecette.getIngredientDetails().getLibIngredientDetails()),
                ingredientRecette.getEstFacultatif(),
                ingredientRecette.getQuantite()

        );

    }


    public IngredientRecetteDto createIngredientRecette(IngredientRecetteDto ingredientRecetteDto) {
        IngredientRecette ingredientRecette = ingredientRecetteMapper.toEntity(ingredientRecetteDto);
        IngredientRecette savedIngredientRecette = ingredientRecetteRepository.save(ingredientRecette);
        return ingredientRecetteMapper.toDto(savedIngredientRecette);
    }


    public IngredientRecetteDto updateIngredientRecette(Integer idIngredient, Integer idEtape,  Integer idUniteMesure, Integer idIngredientDetails, IngredientRecetteDto ingredientRecetteDto) {
        IngredientRecetteId id = new IngredientRecetteId();
        id.setIdIngredient(idIngredient);
        id.setIdEtape(idEtape);
        id.setIdUniteMesure(idUniteMesure);
        id.setIdIngredientDetails(idIngredientDetails);
        IngredientRecette ingredientRecette = ingredientRecetteRepository.findById(id).orElseThrow();
        ingredientRecette.setQuantite(ingredientRecetteDto.getQuantite());
        ingredientRecette.setEstFacultatif(ingredientRecetteDto.getEstFacultatif());
        ingredientRecette = ingredientRecetteRepository.save(ingredientRecette);
        return ingredientRecetteMapper.toDto(ingredientRecette);
    }

    public void deleteIngredientRecette(Integer idIngredient, Integer idEtape,  Integer idUniteMesure, Integer idIngredientDetails) {
        IngredientRecetteId id = new IngredientRecetteId();
        id.setIdIngredient(idIngredient);
        id.setIdEtape(idEtape);
        id.setIdUniteMesure(idUniteMesure);
        id.setIdIngredientDetails(idIngredientDetails);
        ingredientRecetteRepository.deleteById(id);
    }
}

