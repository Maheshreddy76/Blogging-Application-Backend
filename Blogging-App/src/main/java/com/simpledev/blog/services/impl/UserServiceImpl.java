package com.simpledev.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.simpledev.blog.entities.User;
import com.simpledev.blog.payloads.UserDto;
import com.simpledev.blog.repositories.UserRepo;
import com.simpledev.blog.services.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDto createUser(UserDto UserDto) {
		User user=this.userDtoToUser(UserDto);
		User savedUser=userRepo.save(user);
		return this.userToUserDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto UserDto, Integer UserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserById(Integer UserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	public User userDtoToUser(UserDto userDto) {
		User user=new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		return user;
	}
	
	public UserDto userToUserDto(User user) {
		UserDto userDto=new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());
		return userDto;
	}
}
