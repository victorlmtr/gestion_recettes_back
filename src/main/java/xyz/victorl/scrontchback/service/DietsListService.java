package xyz.victorl.scrontchback.service;

import xyz.victorl.scrontchback.model.entity.DietsList;
import xyz.victorl.scrontchback.model.entity.DietsListId;
import xyz.victorl.scrontchback.model.mapper.DietsListMapper;
import xyz.victorl.scrontchback.model.mapper.RegimeRecetteMapper;
import xyz.victorl.scrontchback.model.mapper.EtapeMapper;
import xyz.victorl.scrontchback.repository.DietsListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.victorl.scrontchback.model.dto.DietsListDto;
import xyz.victorl.scrontchback.model.dto.RegimeRecetteDto;
import xyz.victorl.scrontchback.model.dto.UtilisateurDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DietsListService {

    private final DietsListRepository dietsListRepository;
    private final DietsListMapper dietsListMapper;
    private final RegimeRecetteMapper regimeRecetteMapper;
    private final EtapeMapper etapeMapper;

    @Autowired
    public DietsListService(DietsListRepository dietsListRepository, DietsListMapper dietsListMapper, RegimeRecetteMapper regimeRecetteMapper, EtapeMapper etapeMapper) {
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