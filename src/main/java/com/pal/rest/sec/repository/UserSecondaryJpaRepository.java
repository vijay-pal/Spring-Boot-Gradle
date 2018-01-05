package com.pal.rest.sec.repository;

import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pal.rest.model.User;
import com.pal.rest.repository.UserRepository;

@Repository("secondaryUserRepository")
@PersistenceContext(name = "secondaryEntityManagerFactory")
public interface UserSecondaryJpaRepository extends UserRepository, JpaRepository<User, Integer> {
}
