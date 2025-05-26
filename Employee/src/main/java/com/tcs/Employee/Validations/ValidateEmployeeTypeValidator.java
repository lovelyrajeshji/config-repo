package com.tcs.Employee.Validations;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidateEmployeeTypeValidator implements ConstraintValidator<EmployeeTypeValidator, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		List<String> validations = Arrays.asList("Permanent", "Vendor");
		if (validations.contains(value)) {
			return true;
		}
		return false;

	}

}
