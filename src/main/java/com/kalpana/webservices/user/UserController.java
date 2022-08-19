package com.kalpana.webservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
	@Autowired
	UserDaoService userDao;
	
	//Retrieve all users
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userDao.findAll();
		
		
	}
	//Retrieve user by id
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id){
		return userDao.findById(id);
				
	}
	//create users
		@PostMapping("/users")
		public ResponseEntity<Object> createUser(@RequestBody User user){
			User savedUser=userDao.save(user);
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
			System.out.println( ResponseEntity.created(location).build());
		 return ResponseEntity.created(location).build();
		}

}
