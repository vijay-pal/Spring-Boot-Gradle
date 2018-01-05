package com.pal.rest.sec.repository;

import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pal.rest.model.Role;
import com.pal.rest.repository.RoleRepository;

@Repository("secondaryRoleRepository")
@PersistenceContext(name = "secondaryEntityManagerFactory")
public interface RoleSecondaryJpaRepository extends RoleRepository, JpaRepository<Role, Integer> {

}
