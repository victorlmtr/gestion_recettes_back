package com.gestionrecettes.back.service;

import com.gestionrecettes.back.model.dto.ContinentDto;
import com.gestionrecettes.back.model.entity.Continent;
import com.gestionrecettes.back.repository.ContinentRepository;
import com.gestionrecettes.back.model.mapper.ContinentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContinentService {

    @Autowired
    private ContinentRepository continentRepository;

    @Autowired
    private ContinentMapper continentMapper;

    public List<ContinentDto> getAllContinents() {
        List<Continent> continents = continentRepository.findAll();
        return continentMapper.toDtoList(continents);
    }

    public ContinentDto getContinentById(Integer id) {
        Optional<Continent> continent = continentRepository.findById(id);
        return continent.map(continentMapper::toDto).orElse(null);
    }

    public ContinentDto createContinent(ContinentDto continentDto) {
        Continent continent = continentMapper.toEntity(continentDto);
        Continent savedContinent = continentRepository.save(continent);
        return continentMapper.toDto(savedContinent);
    }

    public ContinentDto updateContinent(Integer id, ContinentDto continentDto) {
        if (!continentRepository.existsById(id)) {
            return null; // Or throw an exception
        }
        Continent continent = continentMapper.toEntity(continentDto);
        //continent.setId(id);
        Continent updatedContinent = continentRepository.save(continent);
        return continentMapper.toDto(updatedContinent);
    }

    public void deleteContinent(Integer id) {
        if (continentRepository.existsById(id)) {
            continentRepository.deleteById(id);
        }
    }
}
