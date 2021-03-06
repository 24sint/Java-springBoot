package com.tts.rsvrInClass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tts.rsvrInClass.model.User;
import com.tts.rsvrInClass.service.UserServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping()
	public List<User> GetUsers(){
		return userServiceImpl.findAll();
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		return userServiceImpl.findUserById(id);
	}
	
	@PostMapping()
	public User saveUser(@RequestBody User user) {
		return userServiceImpl.saveUser(user);
	}
	@PutMapping("{id}")
		public User putUser(@PathVariable Long id, @RequestBody User user) {
			return userServiceImpl.updateUserById(id, user);
		
	}
	
	@DeleteMapping("/")
	public void deleteUser(@PathVariable Long id) {
		userServiceImpl.deleteUserById(id);
	}

}
