package xyz.victorl.scrontchback.model.dto;

import lombok.Value;
import xyz.victorl.scrontchback.model.entity.Role;

import java.io.Serializable;

/**
 * DTO for {@link Role}
 */
@Value
public class RoleDto implements Serializable {
    Integer id;
    String libRole;
    
    public RoleDto(Integer id, String libRole) {
        this.id = id;
        this.libRole = libRole;
    }
}