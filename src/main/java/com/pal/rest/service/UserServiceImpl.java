package com.pal.rest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pal.rest.model.User;
import com.pal.rest.model.projection.UserProjection;
import com.pal.rest.prim.repository.UserJpaRepository;
import com.pal.rest.prim.repository.UserMongoRepository;
import com.pal.rest.sec.repository.UserSecondaryJpaRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserJpaRepository repository;

	@Autowired
	private UserSecondaryJpaRepository secondaryRepository;

	@Autowired
	private UserMongoRepository mRepository;

	@Override
	public User saveUser(User user) {
		return repository.save(mRepository.save(secondaryRepository.save(user)));
	}

	@Override
	public User findByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		users.addAll(repository.findAll());
		users.addAll(secondaryRepository.findAll());
		return users;
	}

	@Override
	public boolean isEmailExists(String email) {
		return secondaryRepository.findByEmail(email) != null || repository.findByEmail(email) != null;
	}

	@Override
	public Collection<UserProjection> findByUserName(String userName) {
		return repository.findByUserName(userName);
	}
}
