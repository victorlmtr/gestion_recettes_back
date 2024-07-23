package com.gestionrecettes.back.service;


import com.gestionrecettes.back.model.entity.Role;
import com.gestionrecettes.back.model.entity.Utilisateur;
import com.gestionrecettes.back.repository.RoleRepository;
import com.gestionrecettes.back.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private UtilisateurRepository utilisateurRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AccountServiceImpl(@Lazy UtilisateurRepository utilisateurRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Utilisateur addNewUtilisateur(Utilisateur utilisateur) {
        String pw = utilisateur.getMdpUtilisateur();
        utilisateur.setMdpUtilisateur(passwordEncoder.encode(pw));
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String nomUtilisateur, String libRole) {
        Utilisateur utilisateur = utilisateurRepository.findByNomUtilisateur(nomUtilisateur);
        Role role = roleRepository.findByLibRole(libRole);

        if (utilisateur != null && role != null) {
            utilisateur.getRoleId();
            utilisateurRepository.save(utilisateur);
        }
    }


    @Override
    public Utilisateur getUtilisateur(String nomUtilisateur) {
        return utilisateurRepository.findByNomUtilisateur(nomUtilisateur);
    }

    @Override
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurRepository.findAll();
    }
}
