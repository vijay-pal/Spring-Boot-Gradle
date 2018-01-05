package com.pal.rest.service;

import com.pal.rest.model.Role;

public interface RoleService {
	
	boolean isRoleNameExists(String roleName);

	Role save(Role role);
}
