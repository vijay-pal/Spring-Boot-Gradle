package com.pal.rest.prim.repository;

import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pal.rest.model.User;
import com.pal.rest.repository.UserRepository;

@Repository("userRepository")
@PersistenceContext(name = "entityManagerFactory")
public interface UserJpaRepository extends UserRepository, JpaRepository<User, Integer> {
}
