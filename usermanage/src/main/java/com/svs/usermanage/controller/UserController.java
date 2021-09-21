package com.svs.usermanage.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.svs.usermanage.entity.User;
import com.svs.usermanage.service.UserService;

@RestController
@RequestMapping("/userservice")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		System.out.println("Inside my createUser --Controller");
		User newUser=userService.createUser(user);
		
		return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/users")
	public ResponseEntity<?> getUsers(){
		System.out.println("inside getUsers--controller");
		User newUser=null;
		return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
	}
	
}
