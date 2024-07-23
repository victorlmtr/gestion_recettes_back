package com.gestionrecettes.back.service;

import com.gestionrecettes.back.model.dto.EtapeDto;
import com.gestionrecettes.back.model.entity.Etape;
import com.gestionrecettes.back.model.mapper.EtapeMapper;
import com.gestionrecettes.back.repository.EtapeRepository;
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
}
