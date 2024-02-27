package com.talan.pfemanager.service;

import com.talan.pfemanager.dto.RoleDTO;
import java.util.List;

import org.springframework.stereotype.Service;


public interface RoleService {

    RoleDTO createRole(RoleDTO roleDto);

    RoleDTO getRole(int id);

    List<RoleDTO> getRoles();

    boolean updateRole(int id, RoleDTO roleDto);

    boolean deleteRole(int id);
}
