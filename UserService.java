package com.javacodegeeks.examples.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacodegeeks.examples.entities.User;
import com.javacodegeeks.examples.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;

	}
	public Optional<User> getUser(Integer id) {
		 return userRepository.findById(id);
	}


	public void adduser(User users) {
		userRepository.save(users);
		
	}
	public void updateUser(Integer id, User users) {
		userRepository.save(users);
		
	}
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
		
	}
}
