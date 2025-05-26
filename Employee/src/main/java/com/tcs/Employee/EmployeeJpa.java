package com.tcs.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.Employee.Dto.Employee;

@Repository
public interface EmployeeJpa extends JpaRepository<Employee, Integer> {

}
