package com.gestionrecettes.back.model.mapper;

import com.gestionrecettes.back.model.dto.RoleDto;
import com.gestionrecettes.back.model.entity.Role;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {
    Role toEntity(RoleDto roleDto);

    RoleDto toDto(Role role);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Role partialUpdate(RoleDto roleDto, @MappingTarget Role role);

    List<RoleDto> toDtoList(List<Role> roles);
}