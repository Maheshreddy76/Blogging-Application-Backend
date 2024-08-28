package com.simpledev.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simpledev.blog.payloads.UserDto;
import com.simpledev.blog.services.impl.UserServiceImpl;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	//save user details in DB(POST - Create user)
	@PostMapping("/")
	private ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		UserDto userDtos=userServiceImpl.createUser(userDto);
		return new ResponseEntity<UserDto>(userDtos,HttpStatus.CREATED);
	}
	
	//update user details in DB if that user exists(PUT - Update user details)
	
	
	//get all user details from DB (GET - get all user details)
	
	//delete user details if exists (DELETE - delete user details) 
	
	

}
