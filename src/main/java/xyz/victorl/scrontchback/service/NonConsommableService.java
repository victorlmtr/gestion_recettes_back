package xyz.victorl.scrontchback.service;

import xyz.victorl.scrontchback.model.dto.NonConsommableDto;
import xyz.victorl.scrontchback.model.entity.NonConsommable;
import xyz.victorl.scrontchback.model.mapper.NonConsommableMapper;
import xyz.victorl.scrontchback.repository.NonConsommableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonConsommableService {

    private final NonConsommableRepository nonConsommableRepository;
    private final NonConsommableMapper nonConsommableMapper;

    @Autowired
    public NonConsommableService(NonConsommableRepository nonConsommableRepository, NonConsommableMapper nonConsommableMapper) {
        this.nonConsommableRepository = nonConsommableRepository;
        this.nonConsommableMapper = nonConsommableMapper;
    }

    public List<NonConsommableDto> getAllNonConsommables() {
        List<NonConsommable> nonConsommables = nonConsommableRepository.findAll();
        return nonConsommableMapper.toDtoList(nonConsommables);
    }

    public NonConsommableDto getNonConsommableById(Integer id) {
        return nonConsommableRepository.findById(id)
                .map(nonConsommableMapper::toDto)
                .orElse(null);
    }

    public NonConsommableDto createNonConsommable(NonConsommableDto nonConsommableDto) {
        NonConsommable nonConsommable = nonConsommableMapper.toEntity(nonConsommableDto);
        NonConsommable savedNonConsommable = nonConsommableRepository.save(nonConsommable);
        return nonConsommableMapper.toDto(savedNonConsommable);
    }

    public NonConsommableDto updateNonConsommable(Integer id, NonConsommableDto nonConsommableDto) {
        if (!nonConsommableRepository.existsById(id)) {
            return null;
        }
        NonConsommable nonConsommable = nonConsommableMapper.toEntity(nonConsommableDto);
        nonConsommable.setId(id);
        NonConsommable updatedNonConsommable = nonConsommableRepository.save(nonConsommable);
        return nonConsommableMapper.toDto(updatedNonConsommable);
    }

    public void deleteNonConsommable(Integer id) {
        nonConsommableRepository.deleteById(id);
    }
}

