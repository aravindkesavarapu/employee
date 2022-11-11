package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuppressWarnings("serial")
@Entity
public class Employee implements Serializable {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	@NotBlank(message = "Name is mandatory")
	private String firstName;

	@Column
	@NotBlank(message = "Name is mandatory")
	private String lastName;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Date of Joining is mandatory")
	private Date doj;

	@Column
	@DecimalMin(value = "10.0", message = "Please Enter a valid Salary")
	private double salary;

	private Long[] mobileNumber;

}
