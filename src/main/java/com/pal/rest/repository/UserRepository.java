package com.pal.rest.repository;

import java.util.Collection;

import org.springframework.data.repository.NoRepositoryBean;

import com.pal.rest.model.User;
import com.pal.rest.model.projection.UserProjection;

@NoRepositoryBean
public interface UserRepository {
	User findByEmail(String email);

	Collection<UserProjection> findByUserName(String name);

}
