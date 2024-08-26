package com.gestionrecettes.back.service;

import com.gestionrecettes.back.model.dto.UtilisateurDto;
import com.gestionrecettes.back.model.entity.Utilisateur;
import com.gestionrecettes.back.model.mapper.UtilisateurMapper;
import com.gestionrecettes.back.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository, UtilisateurMapper utilisateurMapper) {
        this.utilisateurRepository = utilisateurRepository;
        this.utilisateurMapper = utilisateurMapper;
    }

    public List<UtilisateurDto> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        return utilisateurs.stream()
                .map(utilisateurMapper::toDto)
                .collect(Collectors.toList());
    }

    public UtilisateurDto getUtilisateurById(Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        return utilisateur.map(utilisateurMapper::toDto).orElse(null);
    }

    public String getUsernameById(Long id) {
        return utilisateurRepository.findById(id)
                .map(Utilisateur::getNomUtilisateur)
                .orElse(null);
    }

    public UtilisateurDto createUtilisateur(UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = utilisateurMapper.toEntity(utilisateurDto);
        Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
        return utilisateurMapper.toDto(savedUtilisateur);
    }

    public UtilisateurDto updateUtilisateur(Long id, UtilisateurDto utilisateurDto) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur utilisateur = optionalUtilisateur.get();
            utilisateurMapper.partialUpdate(utilisateurDto, utilisateur);
            Utilisateur updatedUtilisateur = utilisateurRepository.save(utilisateur);
            return utilisateurMapper.toDto(updatedUtilisateur);
        } else {
            return null;
        }
    }

    public void deleteUtilisateur(Long id) {
        if (utilisateurRepository.existsById(id)) {
            utilisateurRepository.deleteById(id);
        }
    }

    public UtilisateurDto getUtilisateurByNomUtilisateur(String nomUtilisateur) {
        Utilisateur utilisateur = utilisateurRepository.findByNomUtilisateur(nomUtilisateur);
        return utilisateur != null ? utilisateurMapper.toDto(utilisateur) : null;
    }
}
