package com.svs.usermanage.controller;


import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Map<String, Object>> httpMessageNotReadableException(HttpMessageNotReadableException ex) {

		
    	Map<String, Object> body1 = new LinkedHashMap<>();
        body1.put("timestamp", new Date());
        body1.put("status", HttpStatus.BAD_REQUEST.value());
        
        body1.put("errors",ex.getMessage().contains("Failed to parse Date value")?"Invalid Date Format ,accept yyyy-MM-dd":ex.getMessage() );

        return new ResponseEntity<Map<String, Object>>(body1, HttpStatus.BAD_REQUEST);
    	
    }
	
	@PostMapping("/user")
	public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
	
		User newUser=userService.createUser(user);
		
		return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> findAll(){
		
		List<User> user=userService.findAll();
		
		return new ResponseEntity<List<User>>(user,HttpStatus.FOUND);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> findUserById(@PathVariable("id") @Min(value=1,message="Id must be greater than or equal to 1")  long id){
		
		User user=userService.findUserById(id);
		return new ResponseEntity<User>(user,HttpStatus.FOUND);
	}
	
	@PutMapping("/user")
	public ResponseEntity<?> updateUser(@Valid @RequestBody User user) {
		
		User newUser=userService.updateUser(user);
		
		return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") @Min(value=1,message="Id must be greater than or equal to 1")  long id){
		
		userService.deleteUserById(id);
	
		return new ResponseEntity<String>("Succesfully deleted User For Id::"+id,HttpStatus.ACCEPTED);
	}
	
}
