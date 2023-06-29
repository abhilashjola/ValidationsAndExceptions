package com.dakr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dakr.dto.UserRequest;
import com.dakr.entity.User;
import com.dakr.service.UserExistException;
import com.dakr.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private UserService ser;
	
	@PostMapping("/save")
	public ResponseEntity<User> insert(@RequestBody @Valid UserRequest userRequest) throws UserExistException{
		
		return new ResponseEntity<>(ser.saveDtls(userRequest),HttpStatus.BAD_REQUEST);
	}
	
}
