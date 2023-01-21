package com.sas.cache.service;

import java.util.List;
import java.util.Optional;

import com.sas.cache.exception.ObjectNotFoundException;
import com.sas.cache.exception.Response;
import com.sas.cache.repository.UserRepository;
import com.sas.cache.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User saveUser(User userRequest) {
		User user = repository.save(userRequest);
		log.info("User successfully added with userId {}", user.getId());
		return user;
	}

	@Cacheable(value = "userCache", key = "#id", unless = "#result==null")
	public User getUserById(int id) throws ObjectNotFoundException {
		Optional<User> optional = repository.findById(id);
		if (!optional.isPresent()) {
			log.info("User not found with userId {}", id);
			throw new ObjectNotFoundException("No Record found", HttpStatus.NOT_FOUND);
		}
		return optional.get();
	}

	@Cacheable(cacheNames = { "userCache" })
	public List<User> getUsers() {
		return repository.findAll();
	}

	@CachePut(value = "userCache", key = "#id", unless = "#result==null")
	public User updateUser(int id, User userRequest) {
		Optional<User> optional = repository.findById(id);
		if (optional.isPresent()) {
			User user = optional.get();
			user.setName(userRequest.getName());
			user.setEmail(userRequest.getEmail());
			user.setMobile(userRequest.getMobile());
			repository.save(user);
			log.info("User updated successfully with userId {}", id);
			return user;
		}
		return null;
	}

	@CacheEvict(value = "userCache")
	public Response delete(int id) {
		repository.deleteById(id);
		log.info("User deleted with userId {}", id);
		return new Response("User deleted with userId " + id, HttpStatus.NO_CONTENT);
	}
}
