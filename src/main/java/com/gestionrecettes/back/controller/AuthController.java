package com.gestionrecettes.back.controller;

import com.gestionrecettes.back.model.entity.Role;
import com.gestionrecettes.back.model.entity.Utilisateur;
import com.gestionrecettes.back.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthController {
private AccountService accountService;
    @Autowired
    public AuthController(@Lazy AccountService accountService) {
        this.accountService = accountService;
    }

@GetMapping(path="/users")
    public List<Utilisateur> utilisateurs(){
        return accountService.getUtilisateurs();
    }

    @PostMapping(path="/users")
    public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur){
return accountService.addNewUtilisateur(utilisateur);
}

    @PostMapping(path="/roles")
    public Role saveRole(@RequestBody Role role){
        return accountService.addNewRole(role);
    }



}


