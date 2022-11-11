package com.example.demo.service;

import java.text.ParseException;

import com.example.demo.entity.Employee;
import com.example.demo.entity.TaxCompensation;
import com.example.demo.exception.EmployeeNotFoundException;

public interface EmployeeService {

	public Employee createEmp(Employee emp);

	public Employee getEmpDetails(Long id) throws EmployeeNotFoundException;
	
	public TaxCompensation annualSal(Long id) throws ParseException, EmployeeNotFoundException;

}
