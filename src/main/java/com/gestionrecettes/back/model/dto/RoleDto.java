package com.gestionrecettes.back.model.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.gestionrecettes.back.model.entity.Role}
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