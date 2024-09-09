package xyz.victorl.scrontchback.service;

import xyz.victorl.scrontchback.model.dto.EtapeDto;
import xyz.victorl.scrontchback.model.dto.IngredientRecetteDto;
import xyz.victorl.scrontchback.model.entity.Etape;
import xyz.victorl.scrontchback.model.mapper.EtapeMapper;
import xyz.victorl.scrontchback.repository.EtapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtapeService {

    @Autowired
    private EtapeRepository etapeRepository;

    @Autowired
    private EtapeMapper etapeMapper;

    @Autowired
    public IngredientRecetteService ingredientRecetteService;

    public List<EtapeDto> getAllEtapes() {
        List<Etape> etapes = etapeRepository.findAll();
        return etapeMapper.toDtoList(etapes);
    }

    public EtapeDto getEtapeById(Integer id) {
        Optional<Etape> etape = etapeRepository.findById(id);
        return etape.map(etapeMapper::toDto).orElse(null);
    }

    public EtapeDto createEtape(EtapeDto etapeDto) {
        Etape etape = etapeMapper.toEntity(etapeDto);
        Etape savedEtape = etapeRepository.save(etape);
        return etapeMapper.toDto(savedEtape);
    }

    public EtapeDto updateEtape(Integer id, EtapeDto etapeDto) {
        if (!etapeRepository.existsById(id)) {
            return null;
        }
        Etape etape = etapeMapper.toEntity(etapeDto);
        etape.setId(id);
        Etape updatedEtape = etapeRepository.save(etape);
        return etapeMapper.toDto(updatedEtape);
    }

    public void deleteEtape(Integer id) {
        if (etapeRepository.existsById(id)) {
            etapeRepository.deleteById(id);
        }
    }

    public List<IngredientRecetteDto> getIngredientsForEtape(Integer idEtape) {
        return ingredientRecetteService.getIngredientsByEtapeId(idEtape);
    }
}
