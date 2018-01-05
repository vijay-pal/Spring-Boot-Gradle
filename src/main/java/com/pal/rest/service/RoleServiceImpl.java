package com.pal.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.rest.model.Role;
import com.pal.rest.prim.repository.RoleJpaRepository;
import com.pal.rest.sec.repository.RoleSecondaryJpaRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleJpaRepository roleRepository;

	@Autowired
	private RoleSecondaryJpaRepository secondaryRepository;

	@Override
	public Role save(Role role) {
		return secondaryRepository.save(roleRepository.save(role));
	}

	@Override
	public boolean isRoleNameExists(String roleName) {
		return roleRepository.findByRoleName(roleName) != null || secondaryRepository.findByRoleName(roleName) != null;
	}

}
	