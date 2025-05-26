package com.tcs.Employee.Dto;

import java.util.Arrays;
import java.util.List;

public class TESTCLASS {

	public static void main(String[] args) {
		List<Employee> emps = Arrays.asList(
				new Employee(1, "Rajesh", 11000.00, "Mannarpoluru", 7997640418l, "Permanent"),
				new Employee(2, "Aruna", 12000.00, "Kandriga", 7997640419l, "Vendor"),
				new Employee(2, "Shyam", 13000.00, "Dvsathram", 7887640418l, "Permanent"));
		emps.stream().filter(m -> m.getEmpName() == "Aruna" || m.getSalaryOfTheEmp() > 11000.00)
				.forEach(n -> System.out.println(n));
		boolean b = emps.stream().anyMatch(s -> s.equals("Rajesh"));
		System.out.println(b);
	}
}
