package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaxCompensation {

	private long empCode;
	private String firstName;
	private String lastName;
	private int yearlySalary;
	private int taxAmount;
	private int cessAmount;
	private double inHandSalary;

}
