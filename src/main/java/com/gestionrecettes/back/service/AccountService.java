package com.gestionrecettes.back.service;

import com.gestionrecettes.back.model.entity.Role;
import com.gestionrecettes.back.model.entity.Utilisateur;
import java.util.List;

public interface AccountService {
    Utilisateur addNewUtilisateur(Utilisateur utilisateur);
    Role addNewRole(Role role);
    void addRoleToUser(String nomUtilisateur, String libRole);
    Utilisateur getUtilisateur(String nomUtilisateur);
    List<Utilisateur> getUtilisateurs();
}
