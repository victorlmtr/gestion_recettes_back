package xyz.victorl.scrontchback.repository;

import xyz.victorl.scrontchback.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByLibRole(String libRole);
}
