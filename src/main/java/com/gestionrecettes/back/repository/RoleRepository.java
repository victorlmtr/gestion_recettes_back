package com.gestionrecettes.back.repository;

import com.gestionrecettes.back.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByLibRole(String libRole);
}
