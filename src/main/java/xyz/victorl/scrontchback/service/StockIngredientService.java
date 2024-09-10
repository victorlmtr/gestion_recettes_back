package xyz.victorl.scrontchback.service;

import xyz.victorl.scrontchback.model.entity.StockIngredient;
import xyz.victorl.scrontchback.model.entity.StockIngredientId;
import xyz.victorl.scrontchback.model.mapper.StockIngredientMapper;
import xyz.victorl.scrontchback.repository.StockIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.victorl.scrontchback.model.dto.CategorieIngredientDto;
import xyz.victorl.scrontchback.model.dto.IngredientDto;
import xyz.victorl.scrontchback.model.dto.StockIngredientDto;
import xyz.victorl.scrontchback.model.dto.UtilisateurDto;

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
                .toList();
    }
}