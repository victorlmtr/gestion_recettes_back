package com.gestionrecettes.back.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.gestionrecettes.back.model.dto.RegimeRecetteDto;
import com.gestionrecettes.back.model.entity.RegimeRecette;
import com.gestionrecettes.back.model.mapper.RegimeRecetteMapper;
import com.gestionrecettes.back.repository.RegimeRecetteRepository;
@Service
public class RegimeRecetteService {

    private final RegimeRecetteRepository regimeRecetteRepository;
    private final RegimeRecetteMapper regimeRecetteMapper;

    @Autowired
    public RegimeRecetteService(RegimeRecetteRepository regimeRecetteRepository, RegimeRecetteMapper regimeRecetteMapper) {
        this.regimeRecetteRepository = regimeRecetteRepository;
        this.regimeRecetteMapper = regimeRecetteMapper;
    }

    public List<RegimeRecetteDto> getAllRegimes() {
        List<RegimeRecette> regimes = regimeRecetteRepository.findAll();
        return regimeRecetteMapper.toDtoList(regimes);
    }

    public RegimeRecetteDto getRegimeById(Integer id) {
        Optional<RegimeRecette> regime = regimeRecetteRepository.findById(id);
        return regime.map(regimeRecetteMapper::toDto).orElse(null);
    }

    public RegimeRecetteDto createRegime(RegimeRecetteDto regimeRecetteDto) {
        RegimeRecette regime = regimeRecetteMapper.toEntity(regimeRecetteDto);
        RegimeRecette savedRegime = regimeRecetteRepository.save(regime);
        return regimeRecetteMapper.toDto(savedRegime);
    }

    public RegimeRecetteDto updateRegime(Integer id, RegimeRecetteDto regimeRecetteDto) {
        if (!regimeRecetteRepository.existsById(id)) {
            return null;
        }
        RegimeRecette regime = regimeRecetteMapper.toEntity(regimeRecetteDto);
        regime.setId(id);
        RegimeRecette updatedRegime = regimeRecetteRepository.save(regime);
        return regimeRecetteMapper.toDto(updatedRegime);
    }

    public void deleteRegime(Integer id) {
        if (regimeRecetteRepository.existsById(id)) {
            regimeRecetteRepository.deleteById(id);
        }
    }
}

