package com.gestionrecettes.back.controller;

import com.gestionrecettes.back.model.dto.UtilisateurDto;
import com.gestionrecettes.back.model.entity.LoginRequest;
import com.gestionrecettes.back.model.entity.Role;
import com.gestionrecettes.back.model.entity.Utilisateur;
import com.gestionrecettes.back.service.AccountService;
import com.gestionrecettes.back.service.TokenService;
import com.gestionrecettes.back.service.UtilisateurService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AccountService accountService;
    private final UtilisateurService utilisateurService;
    private final TokenService tokenService;

    @Autowired
    public AuthController(@Lazy AccountService accountService, UtilisateurService utilisateurService, TokenService tokenService) {
        this.accountService = accountService;
        this.utilisateurService = utilisateurService;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        // Perform authentication
        Utilisateur utilisateur = accountService.getUtilisateur(username);
        if (utilisateur == null || !tokenService.verifyPassword(password, utilisateur.getMdpUtilisateur())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        // Generate tokens
        String accessToken = tokenService.generateAccessToken(username);
        String refreshToken = tokenService.generateRefreshToken(username);

        // Prepare response
        Map<String, String> tokens = new HashMap<>();
        tokens.put("access-token", accessToken);
        tokens.put("refresh-token", refreshToken);

        return ResponseEntity.ok(tokens);
    }


    // Endpoint to get a list of all users
    @GetMapping("/users")
    public ResponseEntity<List<UtilisateurDto>> getUsers() {
        List<UtilisateurDto> utilisateurs = utilisateurService.getAllUtilisateurs();
        return ResponseEntity.ok(utilisateurs);
    }

    // Endpoint to save a new user
    @PostMapping("/users")
    public ResponseEntity<UtilisateurDto> saveUtilisateur(@RequestBody UtilisateurDto utilisateurDto) {
        UtilisateurDto savedUtilisateur = utilisateurService.createUtilisateur(utilisateurDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUtilisateur);
    }

    // Endpoint to save a new role
    @PostMapping("/roles")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        Role savedRole = accountService.addNewRole(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRole);
    }

    // Endpoint to assign a role to a user
    @PostMapping("/roles/assign")
    public ResponseEntity<Void> assignRoleToUser(@RequestParam String username, @RequestParam String roleName) {
        accountService.addRoleToUser(username, roleName);
        return ResponseEntity.ok().build();
    }

    // Endpoint to get the currently authenticated user's details
    @GetMapping("/me")
    public ResponseEntity<UtilisateurDto> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String username = authentication.getName();
        UtilisateurDto utilisateurDto = utilisateurService.getUtilisateurByNomUtilisateur(username);
        return utilisateurDto != null ? ResponseEntity.ok(utilisateurDto) : ResponseEntity.notFound().build();
    }
}




