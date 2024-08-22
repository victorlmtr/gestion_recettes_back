package com.gestionrecettes.back.service;

import com.gestionrecettes.back.model.dto.*;
import com.gestionrecettes.back.model.entity.Favoris;
import com.gestionrecettes.back.model.entity.FavorisId;
import com.gestionrecettes.back.model.mapper.EtapeMapperImpl;
import com.gestionrecettes.back.model.mapper.FavorisMapper;
import com.gestionrecettes.back.model.mapper.RegimeRecetteMapperImpl;
import com.gestionrecettes.back.repository.FavorisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavorisService {
    private final FavorisRepository favorisRepository;
    private final FavorisMapper favorisMapper;
    private final RegimeRecetteMapperImpl regimeRecetteMapper;
    private final EtapeMapperImpl etapeMapper;

    @Autowired
    public FavorisService(FavorisRepository favorisRepository, FavorisMapper favorisMapper, RegimeRecetteMapperImpl regimeRecetteMapper, EtapeMapperImpl etapeMapper) {
        this.favorisRepository = favorisRepository;
        this.favorisMapper = favorisMapper;
        this.regimeRecetteMapper = regimeRecetteMapper;
        this.etapeMapper = etapeMapper;
    }

    public List<FavorisDto> getAllFavorites() {
        List<Favoris> favorites = favorisRepository.findAll();
        return favorites.stream()
                .map(favoris -> new FavorisDto(
                        new RecetteDto(
                                favoris.getRecette().getId(),
                                favoris.getRecette().getLibRecette(),
                                favoris.getRecette().getDescriptionRecette(),
                                favoris.getRecette().getDifficulteRecette(),
                                favoris.getRecette().getNombrePortion(),
                                favoris.getRecette().getRemarqueRecette(),
                                favoris.getRecette().getDatePublicationRecette(),
                                favoris.getRecette().getImageRecette(),
                                new PaysDto(
                                        favoris.getRecette().getIdPays().getId(),
                                        favoris.getRecette().getIdPays().getLibPays(),
                                        new ContinentDto(
                                                favoris.getRecette().getIdPays().getIdContinent().getId(),
                                                favoris.getRecette().getIdPays().getIdContinent().getLibContinent()
                                        )
                                ),
                                new TypeRecetteDto(
                                        favoris.getRecette().getIdTypeRecette().getId(),
                                        favoris.getRecette().getIdTypeRecette().getLibTypeRecette(),
                                        favoris.getRecette().getIdTypeRecette().getIconeTypeRecette()
                                ),
                                favoris.getRecette().getRegimeRecettes().stream()
                                        .map(regimeRecetteMapper::toDto)
                                        .collect(Collectors.toSet()),
                                favoris.getRecette().getEtapes().stream()
                                        .map(etapeMapper::toDto)
                                        .collect(Collectors.toSet())
                        ),
                        new UtilisateurDto(
                                favoris.getUtilisateur().getId(),
                                favoris.getUtilisateur().getNomUtilisateur(),
                                favoris.getUtilisateur().getEmailUtilisateur(),
                                favoris.getUtilisateur().getMdpUtilisateur(),
                                favoris.getUtilisateur().getDateCreationUtilisateur()
                        ),
                        favoris.getDateFavori()
                )).collect(Collectors.toList());
    }

    public FavorisDto getFavorisById(Integer idUtilisateur, Integer idRecette) {
        FavorisId id = new FavorisId();
        id.setIdRecette(idRecette);
        id.setIdUtilisateur(idUtilisateur);
        Favoris favoris = favorisRepository.findById(id).orElseThrow();
        return new FavorisDto(
                new RecetteDto(
                        favoris.getRecette().getId(),
                        favoris.getRecette().getLibRecette(),
                        favoris.getRecette().getDescriptionRecette(),
                        favoris.getRecette().getDifficulteRecette(),
                        favoris.getRecette().getNombrePortion(),
                        favoris.getRecette().getRemarqueRecette(),
                        favoris.getRecette().getDatePublicationRecette(),
                        favoris.getRecette().getImageRecette(),
                        new PaysDto(
                                favoris.getRecette().getIdPays().getId(),
                                favoris.getRecette().getIdPays().getLibPays(),
                                new ContinentDto(
                                        favoris.getRecette().getIdPays().getIdContinent().getId(),
                                        favoris.getRecette().getIdPays().getIdContinent().getLibContinent()
                                )
                        ),
                        new TypeRecetteDto(
                                favoris.getRecette().getIdTypeRecette().getId(),
                                favoris.getRecette().getIdTypeRecette().getLibTypeRecette(),
                                favoris.getRecette().getIdTypeRecette().getIconeTypeRecette()
                        ),
                        favoris.getRecette().getRegimeRecettes().stream()
                                .map(regimeRecetteMapper::toDto)
                                .collect(Collectors.toSet()),
                        favoris.getRecette().getEtapes().stream()
                                .map(etapeMapper::toDto)
                                .collect(Collectors.toSet())
                ),
                new UtilisateurDto(
                        favoris.getUtilisateur().getId(),
                        favoris.getUtilisateur().getNomUtilisateur(),
                        favoris.getUtilisateur().getEmailUtilisateur(),
                        favoris.getUtilisateur().getMdpUtilisateur(),
                        favoris.getUtilisateur().getDateCreationUtilisateur()
                ),
                favoris.getDateFavori());
    }


    public FavorisDto createFavoris(FavorisDto favorisDto) {
        Favoris favoris = favorisMapper.toEntity(favorisDto);
        Favoris savedFavoris = favorisRepository.save(favoris);
        return favorisMapper.toDto(savedFavoris);
    }

    public FavorisDto updateFavoris(Integer idRecette, Integer idUtilisateur, FavorisDto favorisDto) {
        FavorisId id = new FavorisId();
        id.setIdRecette(idRecette);
        id.setIdUtilisateur(idUtilisateur);
        Favoris favoris = favorisRepository.findById(id).orElseThrow();
        favoris.setDateFavori(favorisDto.getDateFavori());
        favoris = favorisRepository.save(favoris);
        return favorisMapper.toDto(favoris);
    }
    public void deleteFavoris(Integer idRecette, Integer idUtilisateur) {
        FavorisId id = new FavorisId();
        id.setIdRecette(idRecette);
        id.setIdUtilisateur(idUtilisateur);
        favorisRepository.deleteById(id);
    }
}
