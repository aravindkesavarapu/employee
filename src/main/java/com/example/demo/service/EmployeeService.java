package com.example.demo.service;

import java.text.ParseException;

import com.example.demo.entity.Employee;
import com.example.demo.entity.TaxCompensation;

public interface EmployeeService {

	public Employee createEmp(Employee emp);

	public Employee getEmpDetails(Long id);
	
	public TaxCompensation annualSal(Long id) throws ParseException;

}
