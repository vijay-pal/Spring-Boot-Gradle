package com.pal.rest.service;

import java.util.Collection;
import java.util.List;

import com.pal.rest.model.User;
import com.pal.rest.model.projection.UserProjection;

public interface UserService {

	User findByEmail(String email);

	User saveUser(User user);

	boolean isEmailExists(String email);

	List<User> findAll();

	Collection<UserProjection> findByUserName(String userName);
}
