package xyz.victorl.scrontchback.service;

import xyz.victorl.scrontchback.model.entity.Role;
import xyz.victorl.scrontchback.model.entity.Utilisateur;
import java.util.List;

public interface AccountService {
    Utilisateur addNewUtilisateur(Utilisateur utilisateur);
    Role addNewRole(Role role);
    void addRoleToUser(String nomUtilisateur, String libRole);
    Utilisateur getUtilisateur(String nomUtilisateur);
    List<Utilisateur> getUtilisateurs();
}
