package com.example.demo.controller;

import java.text.ParseException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Response;

public interface EmployeeController {

	public ResponseEntity<Response> createEmployee(@RequestBody Employee emp);

	public ResponseEntity<Response> getEmployeeDetails(@PathVariable Long empId);

	public ResponseEntity<Response> annualSal(@PathVariable Long empId) throws ParseException;
}
