package com.pal.rest.repository;

import com.pal.rest.model.Role;

public interface RoleRepository {
	Role findByRoleName(String roleName);
}
