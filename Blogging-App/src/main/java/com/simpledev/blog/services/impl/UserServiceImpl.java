package com.simpledev.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpledev.blog.entities.User;
import com.simpledev.blog.exceptions.ResourceNotFoundException;
import com.simpledev.blog.payloads.UserDto;
import com.simpledev.blog.repositories.UserRepo;
import com.simpledev.blog.services.UserService;

@Service
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
		User user=userRepo.findById(UserId).orElseThrow(()-> new ResourceNotFoundException("User","Id",UserId));
		user.setName(UserDto.getName());
		user.setPassword(UserDto.getPassword());
		user.setEmail(UserDto.getEmail());
		user.setAbout(UserDto.getAbout());
		UserDto UserDto1=this.userToUserDto(userRepo.save(user));
		return UserDto1;
	}

	@Override
	public UserDto getUserById(Integer UserId) {
		User user=userRepo.findById(UserId).orElseThrow(()-> new ResourceNotFoundException("User","Id",UserId));
		return this.userToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users=userRepo.findAll();
		List<UserDto> userDtos=users.stream().map(user ->this.userToUserDto(user)).collect(Collectors.toList());
		return userDtos;
	}
	
	@Override
	public void deleteUser(Integer userId) {
		User user=userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		this.userRepo.delete(user);
		
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
