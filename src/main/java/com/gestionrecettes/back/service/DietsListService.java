package com.gestionrecettes.back.service;

import com.gestionrecettes.back.model.dto.*;
import com.gestionrecettes.back.model.entity.DietsList;
import com.gestionrecettes.back.model.entity.DietsListId;
import com.gestionrecettes.back.model.mapper.DietsListMapper;
import com.gestionrecettes.back.model.mapper.RegimeRecetteMapperImpl;
import com.gestionrecettes.back.model.mapper.EtapeMapperImpl;
import com.gestionrecettes.back.repository.DietsListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DietsListService {

    private final DietsListRepository dietsListRepository;
    private final DietsListMapper dietsListMapper;
    private final RegimeRecetteMapperImpl regimeRecetteMapper;
    private final EtapeMapperImpl etapeMapper;

    @Autowired
    public DietsListService(DietsListRepository dietsListRepository, DietsListMapper dietsListMapper, RegimeRecetteMapperImpl regimeRecetteMapper, EtapeMapperImpl etapeMapper) {
        this.dietsListRepository = dietsListRepository;
        this.dietsListMapper = dietsListMapper;
        this.regimeRecetteMapper = regimeRecetteMapper;
        this.etapeMapper = etapeMapper;
    }

    public List<DietsListDto> getAllDietsLists() {
        List<DietsList> dietsLists = dietsListRepository.findAll();
        return dietsLists.stream()
                .map(dietsList -> new DietsListDto(
                        new UtilisateurDto(
                                dietsList.getUtilisateur().getId(),
                                dietsList.getUtilisateur().getNomUtilisateur(),
                                dietsList.getUtilisateur().getEmailUtilisateur(),
                                dietsList.getUtilisateur().getMdpUtilisateur(),
                                dietsList.getUtilisateur().getDateCreationUtilisateur()
                        ),
                        new RegimeRecetteDto(
                                dietsList.getRegimeRecette().getId(),
                                dietsList.getRegimeRecette().getLibRegimeRecette(),
                                dietsList.getRegimeRecette().getIconeRegimeRecette()
                        )
                        ))
                .collect(Collectors.toList());
    }

    public DietsListDto getDietsListById(Integer idUtilisateur, Integer idRecette) {
        DietsListId id = new DietsListId();
        id.setIdUtilisateur(idUtilisateur);
        id.setIdRegimeRecette(idRecette);
        DietsList dietsList = dietsListRepository.findById(id).orElseThrow();
        return new DietsListDto(
                new UtilisateurDto(
                        dietsList.getUtilisateur().getId(),
                        dietsList.getUtilisateur().getNomUtilisateur(),
                        dietsList.getUtilisateur().getEmailUtilisateur(),
                        dietsList.getUtilisateur().getMdpUtilisateur(),
                        dietsList.getUtilisateur().getDateCreationUtilisateur()
                ),
                new RegimeRecetteDto(
                        dietsList.getRegimeRecette().getId(),
                        dietsList.getRegimeRecette().getLibRegimeRecette(),
                        dietsList.getRegimeRecette().getIconeRegimeRecette()
                )
        );
    }

    public DietsListDto createDietsList(DietsListDto dietsListDto) {
        DietsList dietsList = dietsListMapper.toEntity(dietsListDto);
        DietsList savedDietsList = dietsListRepository.save(dietsList);
        return dietsListMapper.toDto(savedDietsList);
    }

    public DietsListDto updateDietsList(Integer idUtilisateur, Integer idRegimeRecette, DietsListDto dietsListDto) {
        DietsListId id = new DietsListId();
        id.setIdUtilisateur(idUtilisateur);
        id.setIdRegimeRecette(idRegimeRecette);
        DietsList dietsList = dietsListRepository.findById(id).orElseThrow();
        dietsList = dietsListRepository.save(dietsList);
        return dietsListMapper.toDto(dietsList);
    }

    public void deleteDietsList(Integer idUtilisateur, Integer idRegimeRecette) {
        DietsListId id = new DietsListId();
        id.setIdUtilisateur(idUtilisateur);
        id.setIdRegimeRecette(idRegimeRecette);
        dietsListRepository.deleteById(id);
    }
}