package com.tcs.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.Employee.Dto.Employee;
import com.tcs.Employee.Dto.FirstValidated;

@RestController
@Validated
public class EmployeeController {

	@Autowired
	private EmployeeJpa empJpa;

	@PostMapping(value = "saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@Validated(FirstValidated.class) @RequestBody Employee emp) {
		return ResponseEntity.ok(empJpa.save(emp));
	}

	@GetMapping(value = "getHighesalaryEmployeeDetails")
	public Employee getByHighestSalaryDetails() {
		List<Employee> emp = empJpa.findAll();
		Optional<Employee> em = emp.stream().max(Comparator.comparingDouble(Employee::getSalaryOfTheEmp));
		return em.get();
	}

	@GetMapping(value = "groupByEmployeeType")
	public Map<String, List<Employee>> groupByEmployeeType() {
		List<Employee> emp = empJpa.findAll();
		Map<String, List<Employee>> em = emp.stream().collect(Collectors.groupingBy(Employee::getEmpType));
		return em;
	}

}
