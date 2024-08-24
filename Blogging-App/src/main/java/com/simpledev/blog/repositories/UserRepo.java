package com.simpledev.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpledev.blog.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
