package com.pal.rest.prim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pal.rest.model.User;
import com.pal.rest.repository.UserRepository;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserMongoRepository extends UserRepository, MongoRepository<User, Integer> {

}
