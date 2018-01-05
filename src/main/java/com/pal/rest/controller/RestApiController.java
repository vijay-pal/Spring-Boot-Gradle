package com.pal.rest.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pal.rest.model.Role;
import com.pal.rest.model.User;
import com.pal.rest.model.projection.UserProjection;
import com.pal.rest.service.RoleService;
import com.pal.rest.service.UserService;

@RestController
@RequestMapping("/api/v1/")
public class RestApiController {

	@Autowired
	private UserService service;

	@Autowired
	private RoleService roleService;

	@ResponseBody
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String hello() {
		return "Spring rest api demo.";
	}

	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody User user) {
		if (service.isEmailExists(user.getEmail())) {
			return new ResponseEntity<>("User already exists.", HttpStatus.OK);
		}

		user.setUserName(user.getEmail().split("@")[0]);
		return new ResponseEntity<>(service.saveUser(user), HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	public ResponseEntity<?> addRole(@RequestBody Role role) {
		if (roleService.isRoleNameExists(role.getRoleName())) {
			return new ResponseEntity<>("Role name already exists.", HttpStatus.OK);
		}
		return new ResponseEntity<>(roleService.save(role), HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return service.findAll();
	}

	@ResponseBody
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public Collection<UserProjection> getAllUsersByName(@RequestParam("user_name") String userName) {
		return service.findByUserName(userName);
	}
}
