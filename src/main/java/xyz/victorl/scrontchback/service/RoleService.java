package xyz.victorl.scrontchback.service;

import xyz.victorl.scrontchback.model.dto.RoleDto;
import xyz.victorl.scrontchback.model.entity.Role;
import xyz.victorl.scrontchback.model.mapper.RoleMapper;
import xyz.victorl.scrontchback.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Autowired
    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    public List<RoleDto> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roleMapper.toDtoList(roles);
    }

    public RoleDto getRoleById(Integer id) {
        return roleRepository.findById(Long.valueOf(id))
                .map(roleMapper::toDto)
                .orElse(null);
    }

    public RoleDto getRoleByLibRole(String libRole) {
        Role role = roleRepository.findByLibRole(libRole);
        return role != null ? roleMapper.toDto(role) : null;
    }

    public RoleDto createRole(RoleDto roleDto) {
        Role role = roleMapper.toEntity(roleDto);
        Role savedRole = roleRepository.save(role);
        return roleMapper.toDto(savedRole);
    }

    public RoleDto updateRole(Integer id, RoleDto roleDto) {
        if (!roleRepository.existsById(Long.valueOf(id))) {
            return null;
        }
        Role role = roleMapper.toEntity(roleDto);
        role.setId(id);
        Role updatedRole = roleRepository.save(role);
        return roleMapper.toDto(updatedRole);
    }

    public void deleteRole(Integer id) {
        roleRepository.deleteById(Long.valueOf(id));
    }
}
