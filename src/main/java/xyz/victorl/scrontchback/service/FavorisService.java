package xyz.victorl.scrontchback.service;

import xyz.victorl.scrontchback.model.entity.Favoris;
import xyz.victorl.scrontchback.model.entity.FavorisId;
import xyz.victorl.scrontchback.model.mapper.EtapeMapper;
import xyz.victorl.scrontchback.model.mapper.FavorisMapper;
import xyz.victorl.scrontchback.model.mapper.RecetteMapper;
import xyz.victorl.scrontchback.model.mapper.RegimeRecetteMapper;
import xyz.victorl.scrontchback.repository.FavorisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.victorl.scrontchback.model.dto.FavorisDto;
import xyz.victorl.scrontchback.model.dto.RecetteDto;
import xyz.victorl.scrontchback.model.dto.UtilisateurDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavorisService {
    private final FavorisRepository favorisRepository;
    private final FavorisMapper favorisMapper;
    private final RecetteMapper recetteMapper;
    private final RegimeRecetteMapper regimeRecetteMapper;
    private final EtapeMapper etapeMapper;

    @Autowired
    public FavorisService(FavorisRepository favorisRepository, FavorisMapper favorisMapper, RecetteMapper recetteMapper, RegimeRecetteMapper regimeRecetteMapper, EtapeMapper etapeMapper) {
        this.favorisRepository = favorisRepository;
        this.favorisMapper = favorisMapper;
        this.recetteMapper = recetteMapper;
        this.regimeRecetteMapper = regimeRecetteMapper;
        this.etapeMapper = etapeMapper;
    }

    public List<FavorisDto> getAllFavorites() {
        List<Favoris> favorites = favorisRepository.findAll();
        return favorites.stream()
                .map(favoris -> {
                    RecetteDto recetteDto = recetteMapper.toDto(favoris.getRecette());
                    UtilisateurDto utilisateurDto = new UtilisateurDto(
                            favoris.getUtilisateur().getId(),
                            favoris.getUtilisateur().getNomUtilisateur(),
                            favoris.getUtilisateur().getEmailUtilisateur(),
                            favoris.getUtilisateur().getMdpUtilisateur(),
                            favoris.getUtilisateur().getDateCreationUtilisateur()
                    );
                    return new FavorisDto(recetteDto, utilisateurDto, favoris.getDateFavori());
                })
                .collect(Collectors.toList());
    }

    public FavorisDto getFavorisById(Integer idUtilisateur, Integer idRecette) {
        FavorisId id = new FavorisId();
        id.setIdRecette(idRecette);
        id.setIdUtilisateur(idUtilisateur);
        Favoris favoris = favorisRepository.findById(id).orElseThrow();
        RecetteDto recetteDto = recetteMapper.toDto(favoris.getRecette());
        UtilisateurDto utilisateurDto = new UtilisateurDto(
                favoris.getUtilisateur().getId(),
                favoris.getUtilisateur().getNomUtilisateur(),
                favoris.getUtilisateur().getEmailUtilisateur(),
                favoris.getUtilisateur().getMdpUtilisateur(),
                favoris.getUtilisateur().getDateCreationUtilisateur()
        );
        return new FavorisDto(recetteDto, utilisateurDto, favoris.getDateFavori());
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
