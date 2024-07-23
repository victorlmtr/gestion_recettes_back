package com.gestionrecettes.back.service;

import com.gestionrecettes.back.model.dto.PaysDto;
import com.gestionrecettes.back.model.entity.Pays;
import com.gestionrecettes.back.model.mapper.PaysMapper;
import com.gestionrecettes.back.repository.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaysService {

    private final PaysRepository paysRepository;
    private final PaysMapper paysMapper;

    @Autowired
    public PaysService(PaysRepository paysRepository, PaysMapper paysMapper) {
        this.paysRepository = paysRepository;
        this.paysMapper = paysMapper;
    }

    public List<PaysDto> getAllCountries() {
        List<Pays> countries = paysRepository.findAll();
        return paysMapper.toDtoList(countries);
    }

    public PaysDto getCountryById(Integer id) {
        return paysRepository.findById(id)
                .map(paysMapper::toDto)
                .orElse(null);
    }

    public PaysDto createCountry(PaysDto paysDto) {
        Pays pays = paysMapper.toEntity(paysDto);
        Pays savedCountry = paysRepository.save(pays);
        return paysMapper.toDto(savedCountry);
    }

    public PaysDto updateCountry(Integer id, PaysDto paysDto) {
        if (!paysRepository.existsById(id)) {
            return null;
        }
        Pays pays = paysMapper.toEntity(paysDto);
        pays.setId(id);
        Pays updatedCountry = paysRepository.save(pays);
        return paysMapper.toDto(updatedCountry);
    }

    public void deleteCountry(Integer id) {
        paysRepository.deleteById(id);
    }
}
