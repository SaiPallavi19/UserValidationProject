package com.javacodegeeks.examples.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javacodegeeks.examples.entities.User;
import com.javacodegeeks.examples.services.UserService;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;


@RestController
public class userController {
	@Autowired
	private  UserService userService;

	@RequestMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	@RequestMapping("{id}")
	public Optional<User> getUser(@PathVariable Integer id)
	{
		return userService.getUser(id);
	}
	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public void addUser( @Valid @RequestBody User users )
	{
		userService.adduser(users);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
	public void updateTopic(@RequestBody User users,@PathVariable Integer id) {
		userService.updateUser(id,users);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
	public void deleteTopic(@PathVariable Integer id)
	{
		userService.deleteUser(id);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	 
	    ex.getBindingResult().getFieldErrors().forEach(error -> 
	        errors.put(error.getField(), error.getDefaultMessage()));
	     
	    return errors;
	}
}