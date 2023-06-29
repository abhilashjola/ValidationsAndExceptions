package com.dakr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dakr.dto.UserRequest;
import com.dakr.entity.User;
import com.dakr.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public User saveDtls(UserRequest userRequest) throws UserExistException{
		
		User user=new User();
		if(repo.findByEmail(userRequest.getEmail()).isPresent()||repo.findByPassword(userRequest.getPassword()).isPresent())
		{
	
			throw new UserExistException("your already registered");
		}
		else
		{
			user.setName(userRequest.getName());
			//user.setEmail(userRequest.getEmail());
			user.setPassword(userRequest.getPassword());
			repo.save(user);
		}
		
		return user;
	}
}
