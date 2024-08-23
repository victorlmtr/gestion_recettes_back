package com.gestionrecettes.back.service;

import com.gestionrecettes.back.model.dto.*;
import com.gestionrecettes.back.model.entity.StockIngredient;
import com.gestionrecettes.back.model.entity.StockIngredientId;
import com.gestionrecettes.back.model.mapper.StockIngredientMapper;
import com.gestionrecettes.back.model.mapper.RegimeRecetteMapperImpl;
import com.gestionrecettes.back.model.mapper.EtapeMapperImpl;
import com.gestionrecettes.back.repository.StockIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockIngredientService {

    private final StockIngredientRepository stockIngredientRepository;
    private final StockIngredientMapper stockIngredientMapper;

    @Autowired
    public StockIngredientService(StockIngredientRepository stockIngredientRepository, StockIngredientMapper stockIngredientMapper) {
        this.stockIngredientRepository = stockIngredientRepository;
        this.stockIngredientMapper = stockIngredientMapper;
    }

    public List<StockIngredientDto> getAllStocksIngredient() {
        List<StockIngredient> stocksIngredient = stockIngredientRepository.findAll();
        return stocksIngredient.stream()
                .map(stockIngredient -> new StockIngredientDto(
                        new IngredientDto(
                                stockIngredient.getIngredient().getId(),
                                stockIngredient.getIngredient().getLibIngredient(),
                                new CategorieIngredientDto(
                                        stockIngredient.getIngredient().getCategorieIngredient().getId(),
                                        stockIngredient.getIngredient().getCategorieIngredient().getLibCategorieIngredient(),
                                        stockIngredient.getIngredient().getCategorieIngredient().getIconeCategorie()
                                )
                        ),
                        new UtilisateurDto(
                                stockIngredient.getUtilisateur().getId(),
                                stockIngredient.getUtilisateur().getNomUtilisateur(),
                                stockIngredient.getUtilisateur().getEmailUtilisateur(),
                                stockIngredient.getUtilisateur().getMdpUtilisateur(),
                                stockIngredient.getUtilisateur().getDateCreationUtilisateur()
                        )
                        ))
                .collect(Collectors.toList());
    }

    public StockIngredientDto getStockIngredientById(Integer idIngredient, Integer idUtilisateur) {
        StockIngredientId id = new StockIngredientId();
        id.setIdIngredient(idIngredient);
        id.setIdUtilisateur(idUtilisateur);
        StockIngredient stockIngredient = stockIngredientRepository.findById(id).orElseThrow();
        return new StockIngredientDto(
                new IngredientDto(
                        stockIngredient.getIngredient().getId(),
                        stockIngredient.getIngredient().getLibIngredient(),
                        new CategorieIngredientDto(
                                stockIngredient.getIngredient().getCategorieIngredient().getId(),
                                stockIngredient.getIngredient().getCategorieIngredient().getLibCategorieIngredient(),
                                stockIngredient.getIngredient().getCategorieIngredient().getIconeCategorie()
                        )
                ),
                new UtilisateurDto(
                        stockIngredient.getUtilisateur().getId(),
                        stockIngredient.getUtilisateur().getNomUtilisateur(),
                        stockIngredient.getUtilisateur().getEmailUtilisateur(),
                        stockIngredient.getUtilisateur().getMdpUtilisateur(),
                        stockIngredient.getUtilisateur().getDateCreationUtilisateur()
                )
                );
    }

    public StockIngredientDto createStockIngredient(StockIngredientDto stockIngredientDto) {
        StockIngredient stockIngredient = stockIngredientMapper.toEntity(stockIngredientDto);
        StockIngredient savedStockIngredient = stockIngredientRepository.save(stockIngredient);
        return stockIngredientMapper.toDto(savedStockIngredient);
    }

    public StockIngredientDto updateStockIngredient(Integer idIngredient, Integer idUtilisateur, StockIngredientDto stockIngredientDto) {
        StockIngredientId id = new StockIngredientId();
        id.setIdIngredient(idIngredient);
        id.setIdUtilisateur(idUtilisateur);
        StockIngredient stockIngredient = stockIngredientRepository.findById(id).orElseThrow();
        stockIngredient = stockIngredientRepository.save(stockIngredient);
        return stockIngredientMapper.toDto(stockIngredient);
    }

    public void deleteStockIngredient(Integer idIngredient, Integer idUtilisateur) {
        StockIngredientId id = new StockIngredientId();
        id.setIdIngredient(idIngredient);
        id.setIdUtilisateur(idUtilisateur);
        stockIngredientRepository.deleteById(id);
    }

    public List<IngredientDto> getIngredientsForUser(Integer idUtilisateur) {
        List<StockIngredient> stockIngredients = stockIngredientRepository.findByUtilisateurId(idUtilisateur);
        return stockIngredients.stream()
                .map(stockIngredient -> new IngredientDto(
                        stockIngredient.getIngredient().getId(),
                        stockIngredient.getIngredient().getLibIngredient(),
                        new CategorieIngredientDto(
                                stockIngredient.getIngredient().getCategorieIngredient().getId(),
                                stockIngredient.getIngredient().getCategorieIngredient().getLibCategorieIngredient(),
                                stockIngredient.getIngredient().getCategorieIngredient().getIconeCategorie()
                        )
                ))
                .collect(Collectors.toList());
    }
}