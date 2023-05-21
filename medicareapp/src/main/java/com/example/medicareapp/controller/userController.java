package com.example.medicareapp.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.medicareapp.entity.User;
import com.example.medicareapp.repository.UserRepository;
import com.example.medicareapp.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@CrossOrigin("http://localhost:3000")
public class userController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/users")
	public ResponseEntity<?> getUsers() {
		Iterable<User> user = this.userService.findAllUsers();
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/users/{username}/{password}")
	public ResponseEntity<?> getUserByUserName(@PathVariable String username, @PathVariable String password) {
		if(this.userService.findUserByUserNameAndPassword(username,password) != null ) {
			User user = this.userService.findUserByUserNameAndPassword(username,password);
			return ResponseEntity.ok(user);
		} 
		else {
			System.out.println("Invalid User Name or Password!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/user/signup")
	public ResponseEntity<?> createNewUser(@RequestBody User user) {
		if (this.userService.getByUsername(user.getName()) != null) {
			System.out.println("Username already exists!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} else {
			User newUser = this.userService.createUser(user);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(newUser.getUser_id()).toUri();
			return ResponseEntity.created(location).build();
		}
	}
}