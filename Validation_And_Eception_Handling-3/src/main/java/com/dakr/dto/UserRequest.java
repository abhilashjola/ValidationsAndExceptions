package com.dakr.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class UserRequest {

	@NotNull(message="must enter your name")
	private String name;
	@Email(message="Invalid email")
	private String Email;
	@NotNull(message="must should be less than 8 and greater than 5")
	@Min(value=5)
	@Max(value=8)
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserRequest [name=" + name + ", Email=" + Email + ", password=" + password + "]";
	}
	public UserRequest(String name, String email, String password) {
		super();
		this.name = name;
		Email = email;
		this.password = password;
	}
	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
