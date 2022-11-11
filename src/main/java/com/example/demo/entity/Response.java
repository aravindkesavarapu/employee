package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

	private String msg;

	private String status;

	private Employee emp;
	
	private TaxCompensation tax;
	//
//	private long empid;
//
//	private String firstName;
//
//	private String lastName;
//
//	private Date doj;
//
//	private double salary;
//
//	private long mobileNumber;
}
