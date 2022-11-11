package com.example.demo.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.TaxCompensation;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.repositories.EmployeeRepo;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee createEmp(Employee emp) {
		return employeeRepo.saveAndFlush(emp);
	}

	@Override
	public Employee getEmpDetails(Long id) throws EmployeeNotFoundException {
		Optional<Employee> employeeDetails = employeeRepo.findById(id);
		if (employeeDetails.isPresent()) {
			return employeeDetails.get();
		} else {
			throw new EmployeeNotFoundException("Employee not found with empId: "+id);
		}
	}

	@Override
	public TaxCompensation annualSal(Long id) throws ParseException, EmployeeNotFoundException {
		Optional<Employee> employeeDetails = employeeRepo.findById(id);
		if (employeeDetails.isPresent()) {
			System.out.println(employeeDetails.get());
			Employee emp = employeeDetails.get();
			double perday = emp.getSalary() / 30;
			String year = String.valueOf(Year.now().getValue());
			String marchEndDate = "31-03-" + year;
			Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(marchEndDate);
			long diff = (date1.getTime() - emp.getDoj().getTime());
			long convert = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1;
			double annualSal = Math.floor(perday * convert);
			TaxCompensation tax = new TaxCompensation();
			tax.setFirstName(emp.getFirstName());
			tax.setLastName(emp.getLastName());
			tax.setEmpCode(emp.getId());
			tax.setYearlySalary((int) annualSal);
			int taxAmount = (int) (calculateTax(annualSal));
			int cessAmount = cessAmount(annualSal);
			tax.setTaxAmount(taxAmount);
			tax.setCessAmount(cessAmount);
			tax.setInHandSalary(annualSal - taxAmount - cessAmount);
			return tax;
		} else {
			throw new EmployeeNotFoundException("Employee not found with empId: "+id);
		}
	}

	private double calculateTax(double annualSal) {
		if (annualSal <= 250000)
			return annualSal;
		else if (annualSal > 250000 && annualSal <= 500000)
			return (5 * annualSal) / 100;
		else if (annualSal > 500000 && annualSal <= 1000000)
			return (10 * annualSal) / 100;
		else
			return (20 * annualSal) / 100;

	}

	private int cessAmount(double annualSal) {
		if (annualSal >= 2500000)
			return (int) (annualSal - (2 * annualSal) / 100);

		return 0;
	}

}
