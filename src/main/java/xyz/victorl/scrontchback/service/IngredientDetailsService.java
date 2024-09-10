package xyz.victorl.scrontchback.service;

import xyz.victorl.scrontchback.model.dto.IngredientDetailsDto;
import xyz.victorl.scrontchback.model.entity.IngredientDetails;
import xyz.victorl.scrontchback.model.mapper.IngredientDetailsMapper;
import xyz.victorl.scrontchback.repository.IngredientDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientDetailsService {

    private final IngredientDetailsRepository ingredientDetailsRepository;
    private final IngredientDetailsMapper ingredientDetailsMapper;

    @Autowired
    public IngredientDetailsService(IngredientDetailsRepository ingredientDetailsRepository, IngredientDetailsMapper ingredientDetailsMapper) {
        this.ingredientDetailsRepository = ingredientDetailsRepository;
        this.ingredientDetailsMapper = ingredientDetailsMapper;
    }

    public List<IngredientDetailsDto> getAllDetails() {
        List<IngredientDetails> details = ingredientDetailsRepository.findAll();
        return ingredientDetailsMapper.toDtoList(details);
    }

    public IngredientDetailsDto getDetailsById(Integer id) {
        Optional<IngredientDetails> detail = ingredientDetailsRepository.findById(id);
        return detail.map(ingredientDetailsMapper::toDto).orElse(null);
    }

    public IngredientDetailsDto createDetail(IngredientDetailsDto ingredientDetailsDto) {
        IngredientDetails detail = ingredientDetailsMapper.toEntity(ingredientDetailsDto);
        IngredientDetails savedDetail = ingredientDetailsRepository.save(detail);
        return ingredientDetailsMapper.toDto(savedDetail);
    }

    public IngredientDetailsDto updateDetail(Integer id, IngredientDetailsDto ingredientDetailsDto) {
        if (!ingredientDetailsRepository.existsById(id)) {
            return null;
        }
        IngredientDetails detail = ingredientDetailsMapper.toEntity(ingredientDetailsDto);
        detail.setId(id);
        IngredientDetails updatedDetail = ingredientDetailsRepository.save(detail);
        return ingredientDetailsMapper.toDto(updatedDetail);
    }

    public void deleteDetail(Integer id) {
        if (ingredientDetailsRepository.existsById(id)) {
            ingredientDetailsRepository.deleteById(id);
        }
    }
}
