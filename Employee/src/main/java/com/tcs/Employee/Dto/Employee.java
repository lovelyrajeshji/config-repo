package com.tcs.Employee.Dto;

import com.tcs.Employee.Validations.EmployeeTypeValidator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "EmployeeDetails")
@Data
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "EmpName")
	@NotBlank(message = "Name should not be Empty", groups = FirstValidated.class)
	private String empName;
	@Min(value = 10000)
	@Max(value = 20000)
	private double salaryOfTheEmp;
	@NotBlank
	private String presentAddress;
	@Column(unique = true, length = 10)
	private long phNumber;
	@EmployeeTypeValidator
	private String empType;
}
