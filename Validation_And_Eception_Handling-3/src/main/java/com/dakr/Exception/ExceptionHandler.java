package com.dakr.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dakr.service.UserExistException;

@RestControllerAdvice
public class ExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleException(MethodArgumentNotValidException exe){
		
		Map<String,String> errorMap=new HashMap<>();
		exe.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		
		return errorMap;
	}
	
	

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(UserExistException.class)
	public Map<String, String> handleException(UserExistException ex){
		
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error message", ex.getMessage());
		return errorMap;
	}
}
