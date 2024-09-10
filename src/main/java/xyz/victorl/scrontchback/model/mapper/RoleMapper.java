package xyz.victorl.scrontchback.model.mapper;

import xyz.victorl.scrontchback.model.dto.RoleDto;
import xyz.victorl.scrontchback.model.entity.Role;
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