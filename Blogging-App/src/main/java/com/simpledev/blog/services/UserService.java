package com.simpledev.blog.services;

import java.util.List;

import com.simpledev.blog.payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto UserDto);
	
	UserDto updateUser(UserDto UserDto,Integer UserId);
	
	UserDto getUserById(Integer UserId);
	
	List<UserDto> getAllUsers();

}
