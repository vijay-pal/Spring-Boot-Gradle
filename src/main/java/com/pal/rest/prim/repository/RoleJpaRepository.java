package com.pal.rest.prim.repository;

import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pal.rest.model.Role;
import com.pal.rest.repository.RoleRepository;

@Repository("roleRepository")
@PersistenceContext(name = "entityManagerFactory")
public interface RoleJpaRepository extends RoleRepository, JpaRepository<Role, Integer> {

}
