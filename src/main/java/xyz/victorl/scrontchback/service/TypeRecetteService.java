package xyz.victorl.scrontchback.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import xyz.victorl.scrontchback.model.dto.TypeRecetteDto;
import xyz.victorl.scrontchback.model.entity.TypeRecette;
import xyz.victorl.scrontchback.model.mapper.TypeRecetteMapper;
import xyz.victorl.scrontchback.repository.TypeRecetteRepository;

@Service
public class TypeRecetteService {

    private final TypeRecetteRepository typeRecetteRepository;
    private final TypeRecetteMapper typeRecetteMapper;

    @Autowired
    public TypeRecetteService(TypeRecetteRepository typeRecetteRepository, TypeRecetteMapper typeRecetteMapper) {
        this.typeRecetteRepository = typeRecetteRepository;
        this.typeRecetteMapper = typeRecetteMapper;
    }

    public List<TypeRecetteDto> getAllTypes() {
        List<TypeRecette> types = typeRecetteRepository.findAll();
        return typeRecetteMapper.toDtoList(types);
    }

    public TypeRecetteDto getTypeById(Integer id) {
        Optional<TypeRecette> type = typeRecetteRepository.findById(id);
        return type.map(typeRecetteMapper::toDto).orElse(null);
    }

    public TypeRecetteDto createType(TypeRecetteDto typeRecetteDto) {
        TypeRecette type = typeRecetteMapper.toEntity(typeRecetteDto);
        TypeRecette savedType = typeRecetteRepository.save(type);
        return typeRecetteMapper.toDto(savedType);
    }

    public TypeRecetteDto updateType(Integer id, TypeRecetteDto typeRecetteDto) {
        if (!typeRecetteRepository.existsById(id)) {
            return null;
        }
        TypeRecette type = typeRecetteMapper.toEntity(typeRecetteDto);
        type.setId(id);
        TypeRecette updatedType = typeRecetteRepository.save(type);
        return typeRecetteMapper.toDto(updatedType);
    }

    public void deleteType(Integer id) {
        if (typeRecetteRepository.existsById(id)) {
            typeRecetteRepository.deleteById(id);
        }
    }
}

