package com.example.demo.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.entity.EmployeeResponse;
import com.example.demo.exception.EmployeeException;

@RestControllerAdvice
public class EmployeeControllerAdvice {
	@ExceptionHandler
	public EmployeeResponse myExceptionHandler(EmployeeException empException) {
		EmployeeResponse response = new EmployeeResponse();
		response.setError(true);
		response.setMessage(empException.getMessage());
		return response;
	}
}
