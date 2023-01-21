package com.sas.cache.controller;

import com.sas.cache.entity.User;
import com.sas.cache.exception.ObjectNotFoundException;
import com.sas.cache.exception.Response;
import com.sas.cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping
	public User saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	@GetMapping
	public List<User> getUsers() {
		return service.getUsers();
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable int id) throws ObjectNotFoundException {
		return service.getUserById(id);
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User user) {
		return service.updateUser(id, user);
	}

	@DeleteMapping("/{id}")
	public Response deleteUser(@PathVariable int id) {
		return service.delete(id);
	}

}
