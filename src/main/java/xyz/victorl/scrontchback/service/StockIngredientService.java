package xyz.victorl.scrontchback.service;

import xyz.victorl.scrontchback.model.entity.Ingredient;
import xyz.victorl.scrontchback.model.entity.StockIngredient;
import xyz.victorl.scrontchback.model.entity.StockIngredientId;
import xyz.victorl.scrontchback.model.entity.Utilisateur;
import xyz.victorl.scrontchback.model.mapper.StockIngredientMapper;
import xyz.victorl.scrontchback.repository.IngredientRepository;
import xyz.victorl.scrontchback.repository.StockIngredientRepository;
import xyz.victorl.scrontchback.repository.UtilisateurRepository;
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
    private final IngredientRepository ingredientRepository;
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public StockIngredientService(StockIngredientRepository stockIngredientRepository,
                                  StockIngredientMapper stockIngredientMapper,
                                  IngredientRepository ingredientRepository,
                                  UtilisateurRepository utilisateurRepository) {
        this.stockIngredientRepository = stockIngredientRepository;
        this.stockIngredientMapper = stockIngredientMapper;
        this.ingredientRepository = ingredientRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<StockIngredientDto> getAllStocksIngredient() {
        List<StockIngredient> stocksIngredient = stockIngredientRepository.findAll();
        return stocksIngredient.stream()
                .map(stockIngredient -> new StockIngredientDto(
                        stockIngredient.getIngredient().getId(),
                        stockIngredient.getUtilisateur().getId()
                ))
                .collect(Collectors.toList());
    }

    public StockIngredientDto getStockIngredientById(Integer idIngredient, Integer idUtilisateur) {
        StockIngredientId id = new StockIngredientId();
        id.setIdIngredient(idIngredient);
        id.setIdUtilisateur(idUtilisateur);
        StockIngredient stockIngredient = stockIngredientRepository.findById(id).orElseThrow();
        return new StockIngredientDto(
                stockIngredient.getIngredient().getId(),
                stockIngredient.getUtilisateur().getId()
        );
    }

    public StockIngredientDto createStockIngredient(StockIngredientDto stockIngredientDto) {
        Ingredient ingredient = ingredientRepository.findById(stockIngredientDto.getIdIngredient())
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
        Utilisateur utilisateur = utilisateurRepository.findById(Long.valueOf(stockIngredientDto.getIdUtilisateur()))
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));

        StockIngredient stockIngredient = new StockIngredient();
        StockIngredientId stockIngredientId = new StockIngredientId();
        stockIngredientId.setIdIngredient(ingredient.getId());
        stockIngredientId.setIdUtilisateur(utilisateur.getId());
        stockIngredient.setId(stockIngredientId);
        stockIngredient.setIngredient(ingredient);
        stockIngredient.setUtilisateur(utilisateur);

        StockIngredient savedStockIngredient = stockIngredientRepository.save(stockIngredient);
        return new StockIngredientDto(savedStockIngredient.getIngredient().getId(),
                savedStockIngredient.getUtilisateur().getId());
    }

    public StockIngredientDto updateStockIngredient(Integer idIngredient, Integer idUtilisateur, StockIngredientDto stockIngredientDto) {
        StockIngredientId id = new StockIngredientId();
        id.setIdIngredient(idIngredient);
        id.setIdUtilisateur(idUtilisateur);

        StockIngredient stockIngredient = stockIngredientRepository.findById(id).orElseThrow(() -> new RuntimeException("StockIngredient not found"));

        // Update logic here if any fields need to be updated, else return as is
        StockIngredient savedStockIngredient = stockIngredientRepository.save(stockIngredient);
        return new StockIngredientDto(savedStockIngredient.getIngredient().getId(),
                savedStockIngredient.getUtilisateur().getId());
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
