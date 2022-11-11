package com.example.demo.controller;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Response;
import com.example.demo.exception.EmployeeNotFoundException;

public interface EmployeeController {

	public ResponseEntity<Response> createEmployee(@Valid @RequestBody Employee emp);

	public ResponseEntity<Response> getEmployeeDetails(@PathVariable Long empId) throws EmployeeNotFoundException;

	public ResponseEntity<Response> annualSal(@PathVariable Long empId) throws ParseException, EmployeeNotFoundException;
}
