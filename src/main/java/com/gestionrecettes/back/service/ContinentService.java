package com.gestionrecettes.back.service;

import com.gestionrecettes.back.model.dto.ContinentDto;
import com.gestionrecettes.back.model.entity.Continent;
import com.gestionrecettes.back.model.mapper.ContinentMapper;
import com.gestionrecettes.back.repository.ContinentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinentService {

    private final ContinentRepository continentRepository;
    private final ContinentMapper continentMapper;

    @Autowired
    public ContinentService(ContinentRepository continentRepository, ContinentMapper continentMapper) {
        this.continentRepository = continentRepository;
        this.continentMapper = continentMapper;
    }

    public List<ContinentDto> getAllContinents() {
        List<Continent> continents = continentRepository.findAll();
        return continentMapper.toDtoList(continents);
    }

    public ContinentDto getContinentById(Integer id) {
        return continentRepository.findById(id)
                .map(continentMapper::toDto)
                .orElse(null);
    }

    public ContinentDto createContinent(ContinentDto continentDto) {
        Continent continent = continentMapper.toEntity(continentDto);
        Continent savedContinent = continentRepository.save(continent);
        return continentMapper.toDto(savedContinent);
    }

    public ContinentDto updateContinent(Integer id, ContinentDto continentDto) {
        if (!continentRepository.existsById(id)) {
            return null;
        }
        Continent continent = continentMapper.toEntity(continentDto);
        continent.setId(id);
        Continent updatedContinent = continentRepository.save(continent);
        return continentMapper.toDto(updatedContinent);
    }

    public void deleteContinent(Integer id) {
        continentRepository.deleteById(id);
    }



}
