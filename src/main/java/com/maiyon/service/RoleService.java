package com.maiyon.service;

import com.maiyon.model.entity.Role;
import com.maiyon.model.enums.RoleName;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findByRoleName(RoleName roleName);
}
