package com.talan.pfemanager.service.Impl;

import com.talan.pfemanager.dto.RoleDTO;
import com.talan.pfemanager.entity.Role;
import com.talan.pfemanager.helper.RoleHelper;
import com.talan.pfemanager.repository.RoleRepository;
import com.talan.pfemanager.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepository roleRepo;
    
    @Override
    public RoleDTO createRole(RoleDTO roleDto) {
        Role role = RoleHelper.dtoToEntity(roleDto);
        Role createdRole = roleRepo.save(role);
        return RoleHelper.entityToDto(createdRole);
    }
    
    @Override
    public RoleDTO getRole(int id) {
        Role role = roleRepo.findById(id).get();
        return RoleHelper.entityToDto(role);
    }
    
    @Override
    public List<RoleDTO> getRoles() {
        List<Role> roles = roleRepo.findAll();
        return RoleHelper.entityToDto(roles);
    }
    
    @Override
    public boolean updateRole(int id, RoleDTO roleDto) {
        Role role = RoleHelper.dtoToEntity(roleDto);
        if(roleRepo.findById(id).get()!=null) {
            roleRepo.save(role);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean deleteRole(int id) {
        if(roleRepo.findById(id)!=null) {
            roleRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
