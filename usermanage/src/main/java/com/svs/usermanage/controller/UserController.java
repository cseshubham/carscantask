package com.svs.usermanage.controller;


import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.svs.usermanage.entity.User;
import com.svs.usermanage.service.UserService;

@RestController
@RequestMapping("/userservice")
@Validated
public class UserController {

	@Autowired
	UserService userService;
	
	
	@PostMapping("/user")
	public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
		System.out.println("Inside my createUser --Controller");
		User newUser=userService.createUser(user);
		
		return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> findAll(){
		System.out.println("inside findUserById--controller");
		List<User> user=userService.findAll();
		return new ResponseEntity<List<User>>(user,HttpStatus.FOUND);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> findUserById(@PathVariable("id") @Min(value=1,message="Id must be greater than or equal to 1")  long id){
		System.out.println("inside findUserById--controller");
		User user=userService.findUserById(id);
		return new ResponseEntity<User>(user,HttpStatus.FOUND);
	}
	
	@PutMapping("/user")
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		
		System.out.println("Inside my updateUser --Controller");
		User newUser=userService.updateUser(user);
		
		return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") long id){
		System.out.println("inside deleteUserById--controller");
		userService.deleteUserById(id);
		return new ResponseEntity<String>("Successfully Deleted",HttpStatus.NO_CONTENT);
	}
	
}
