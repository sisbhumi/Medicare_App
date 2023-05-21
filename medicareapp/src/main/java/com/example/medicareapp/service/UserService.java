package com.example.medicareapp.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medicareapp.entity.User;
import com.example.medicareapp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	public UserRepository user_repo;

	public Iterable<User> findAllUsers() {
		return this.user_repo.findAll();
	}

	public Object getByUsername(String name) {
		return this.user_repo.findByName(name);
	}

	public User createUser( User user) {
		return this.user_repo.save(user);
		
	}

	public User findUserByUserName(String name) {
		// TODO Auto-generated method stub
		return this.user_repo.findByUsername(name);
	}

	public User findUserByUserNameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return this.user_repo.findByUsernameAndPassword(username,password);
	}

}