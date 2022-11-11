package com.example.demo.controller.impl;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.EmployeeController;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Response;
import com.example.demo.entity.TaxCompensation;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeControllerImpl implements EmployeeController {

	@Autowired
	private EmployeeService empService;

	@Override
	@PostMapping("/create")
	public ResponseEntity<Response> createEmployee(@Valid @RequestBody Employee emp) {
		Employee createEmp = empService.createEmp(emp);
		Response res = new Response();
		res.setEmp(createEmp);
		return new ResponseEntity<Response>(res, HttpStatus.OK);
	}

	@Override
	@GetMapping("/employee/{empId}")
	public ResponseEntity<Response> getEmployeeDetails(@PathVariable Long empId) throws EmployeeNotFoundException {
		Employee empDetails = empService.getEmpDetails(empId);
		Response res = new Response();
		res.setEmp(empDetails);
		return new ResponseEntity<Response>(res, HttpStatus.OK);
	}

	@Override
	@GetMapping("/annual/{empId}")
	public ResponseEntity<Response> annualSal(@PathVariable Long empId)
			throws ParseException, EmployeeNotFoundException {
		TaxCompensation taxDetails = empService.annualSal(empId);
		Response res = new Response();
		res.setTax(taxDetails);
		return new ResponseEntity<Response>(res, HttpStatus.OK);

	}

}
