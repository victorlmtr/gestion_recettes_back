package com.gestionrecettes.back.service;

import com.gestionrecettes.back.model.dto.UniteMesureDto;
import com.gestionrecettes.back.model.entity.UniteMesure;
import com.gestionrecettes.back.model.mapper.UniteMesureMapper;
import com.gestionrecettes.back.repository.UniteMesureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniteMesureService {

    private final UniteMesureRepository uniteMesureRepository;
    private final UniteMesureMapper uniteMesureMapper;

    @Autowired
    public UniteMesureService(UniteMesureRepository uniteMesureRepository, UniteMesureMapper uniteMesureMapper) {
        this.uniteMesureRepository = uniteMesureRepository;
        this.uniteMesureMapper = uniteMesureMapper;
    }

    public List<UniteMesureDto> getAllUnitesMesure() {
        List<UniteMesure> unitesMesure = uniteMesureRepository.findAll();
        return uniteMesureMapper.toDtoList(unitesMesure);
    }

    public UniteMesureDto getUniteMesureById(Integer id) {
        Optional<UniteMesure> category = uniteMesureRepository.findById(id);
        return category.map(uniteMesureMapper::toDto).orElse(null);
    }

    public UniteMesureDto createUniteMesure(UniteMesureDto uniteMesureDto) {
        UniteMesure uniteMesure = uniteMesureMapper.toEntity(uniteMesureDto);
        UniteMesure savedUniteMesure = uniteMesureRepository.save(uniteMesure);
        return uniteMesureMapper.toDto(savedUniteMesure);
    }

    public UniteMesureDto updateUniteMesure(Integer id, UniteMesureDto uniteMesureDto) {
        if (!uniteMesureRepository.existsById(id)) {
            return null;
        }
        UniteMesure uniteMesure = uniteMesureMapper.toEntity(uniteMesureDto);
        uniteMesure.setId(id);
        UniteMesure updatedUniteMesure = uniteMesureRepository.save(uniteMesure);
        return uniteMesureMapper.toDto(updatedUniteMesure);
    }

    public void deleteUniteMesure(Integer id) {
        if (uniteMesureRepository.existsById(id)) {
            uniteMesureRepository.deleteById(id);
        }
    }
}
